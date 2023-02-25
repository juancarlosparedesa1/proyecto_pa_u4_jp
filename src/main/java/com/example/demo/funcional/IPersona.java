package com.example.demo.funcional;

//sin la anotacion si es una interfaz funcional
//la buena practica es que tenga la anotacion
@FunctionalInterface
public interface IPersona {
	public String comer();
	//solo acepta un método
	//public String caminar();

}
