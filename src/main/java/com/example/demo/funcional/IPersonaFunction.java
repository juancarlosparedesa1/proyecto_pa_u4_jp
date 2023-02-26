package com.example.demo.funcional;

import java.util.List;
@FunctionalInterface
public interface IPersonaFunction <R,T> {
	public R aplicar(T arg1);
	//recibe un tipo de dato (T arg1) y retorna otro
	//tipo de dato (R)
	
}
