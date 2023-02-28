package com.example.demo.paralelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainSecuencialStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> idEstudiantes = new ArrayList();
		for (int i = 1; i <= 10; i++) {
			idEstudiantes.add(i);
		}
		idEstudiantes.forEach(numero -> System.out.println("Estudiante:" + numero));
		//procesar cada estudinate
		long tiempoInicial=System.currentTimeMillis();
		//convertir un dato de la lista a stream
		//List<String> listaFinal= idEstudiantes.stream().map(id->procesarIdEstudiante(id)).collect(Collectors.toList());
		List<String> listaFinal = idEstudiantes.stream().map(id -> procesarIdEstudiante(id)).collect(Collectors.toList());
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido =(tiempoFinal-tiempoInicial)/1000;
		listaFinal.forEach(cadena->System.out.println(cadena));
		System.out.println("Tiempo transcurrido en segundos:"+tiempoTranscurrido);
		
	}

	public static String procesarIdEstudiante(Integer idEstudiante) {

		String idConvertido = "E" + idEstudiante.toString();
		//insertar a la bd simular
		System.out.println("Insertando estudiante: "+idConvertido+"hilo: "+Thread.currentThread().getName());
		//1 segundo
		try {
			//1 segundo duerma 1 segundo
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idConvertido;
	}
}
