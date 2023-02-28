package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	// IMPRESION MAS DETALLADO
	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// 1.SUPPLIER
		LOG.info("1.SUPPLIER");
		// Clases
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier Clase" + supplier1.getNombre());
		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "Juan 2";
		LOG.info("Supplier Lambda" + supplier2.getNombre());
		System.out.println("Supplier Lambda" + supplier2.getNombre());

		// aqui se tacha
		// IPersonaSupplier<Integer> supplier3 =() -> new Integer(5);
		// si se tacha hay una mejor forma de hacer
		IPersonaSupplier<Integer> supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier Lambda" + supplier3.getNombre());

//		//imprime una persona vacioa
//		IPersonaSupplier<Persona> supplier4 = () -> new Persona();
//		LOG.info("Supplier Lambda"+supplier3.getNombre());

		// imprime una persona vacioa
		IPersonaSupplier<Persona> supplier4 = () -> {
			Persona per = new Persona();
			per.setApellido("Paredes");
			per.setNombre("juan");
			return per;
		};
		LOG.info("Supplier Lambda" + supplier4.getNombre());
		IPersonaSupplier<Persona> supplier5 = new PersonaSupplier2Impl();
		LOG.info("Supplier Lambda" + supplier5.getNombre());

		// JAVA

		LOG.info("JAVA supplier");
		// me permite generar un string
		Stream<String> lista = Stream.generate((() -> "Juan")).limit(10);
		// imprimierle con otro tipo de funcion lambda
		lista.forEach(cadena -> LOG.info(cadena));

		// 2.CONSUMER
		LOG.info("2.CONSUMER");

		// Clase
		IPersonaConsumer<String, Integer> consumer1 = new PersonaConsumerImpl();
		consumer1.accept("procesa este dato:", Integer.valueOf(10));

		// lambda
		IPersonaConsumer<String, Integer> consumer2 = (cadena, numero) -> {
			LOG.info("mensaje a:" + cadena);
			LOG.info("mensaje b:" + cadena);
			LOG.info("mensaje c:" + numero);
		};
		consumer2.accept("procesa este dato2", Integer.valueOf(15));

		IPersonaConsumer<Integer, Integer> consumer3 = (valor1, valor2) -> {
			Integer valor3 = valor1.intValue() + valor2.intValue();
			LOG.info("mensaje c:" + valor3);

		};
		consumer3.accept(Integer.valueOf(5), Integer.valueOf(10));

		// JAVA
		LOG.info("JAVA Consumer");

		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 56, 70);
		listaNumeros.forEach(numero -> LOG.info("Valor: " + numero));

		for (Integer val : listaNumeros) {
			LOG.info("Valor:" + val);
		}

		// 3.PREDICATE
		LOG.info("3.PREDICATE");
		// Lambdas-implememntaciones
		// me aseguro que tenga un return booleano
		IPersonaPredicate<String> predicate1 = cadena -> cadena.contains("Z");
		LOG.info("Predicate:" + predicate1.evaluar("Juan"));

		IPersonaPredicate<Integer> predicate2 = numero -> {
			if (numero.intValue() > 10) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate:" + predicate2.evaluar(Integer.valueOf(11)));

		// JAVA
		LOG.info("JAVA Predicate");
		{

			listaNumeros.stream().filter(numero -> numero > 3);

			// 4.FUNCTION
			LOG.info("4.FUNCTION");
			// recomendacion cuando declaro la interfaz
			// 1ero retorno y luego lo que recibe
			IPersonaFunction<String, Integer> function = numero -> "Valor: " + numero.toString();
			LOG.info(function.aplicar(10));

			IPersonaFunction<Ciudadano, Persona> function2 = per -> {
				Ciudadano ciu = new Ciudadano();
				ciu.setNombreCompleto(per.getNombre() + " " + per.getApellido());
				ciu.setCiduad("Quito");
				return ciu;

			};

			Persona per1 = new Persona();
			per1.setNombre("Juan");
			per1.setApellido("Paredes");
			Ciudadano ciudadanoConvertido = function2.aplicar(per1);
			LOG.info("Ciudadano convertido:" + ciudadanoConvertido);

			// JAVA
			LOG.info("JAVA Function");
			Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
				Integer valorFinal = numeroLista + 1;
				String cadena = "num: " + valorFinal.toString();
				return cadena;
			});
			listaCambiada.forEach(cadena -> LOG.info(cadena));

			// 5.UNARYOPERATOR
			LOG.info("5.UNARYOPERATOR");
			// lambdas
			IPersonaUnaryOperator<String> unaryOperator = cadena -> {
				String cadenaFinal = cadena.concat("-sufijo");
				return cadenaFinal;
			};
			LOG.info("UnaryOperator: " + unaryOperator.aplicar("Daniel"));

			// java

		}
	}
}
