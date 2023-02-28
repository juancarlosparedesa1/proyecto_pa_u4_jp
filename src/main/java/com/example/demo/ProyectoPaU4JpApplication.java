package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.funcional.Ciudadano;
import com.example.demo.repo.ICiudadanoRepo;

@SpringBootApplication
public class ProyectoPaU4JpApplication implements CommandLineRunner {

	 @Autowired
	 private ICiudadanoRepo ciudadanoRepo;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4JpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
