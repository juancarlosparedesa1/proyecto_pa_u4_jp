package com.example.demo.paralelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> idEstudiantes = new ArrayList<>();
		for(int i=1; i<=100;i++) {
			idEstudiantes.add(i);
		}
		 idEstudiantes.forEach(numero -> System.out.println("Estudiante: "+numero));
		 //Procesar estudiantes
		 long tiempoInicial= System.currentTimeMillis();
		 List<String>listafinal = idEstudiantes.parallelStream().map(id -> procesarIdEstudiante(id)).collect(Collectors.toList());		 
		 long tiempoFinal= System.currentTimeMillis();
		 long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
		 listafinal.forEach(cadena -> System.out.println(cadena));
		 System.out.println("Tiempo transcurrido: "+tiempoTranscurrido);
	}
	
	public static String procesarIdEstudiante(Integer idEstudiante) {
		//Convertir a string
		String idConvertido="E"+idEstudiante.toString();
		//Se inserta en la base
		System.out.println("Insertando estudiante: "+idConvertido+" hilo: "+Thread.currentThread().getName());
		//1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idConvertido;
	}

}