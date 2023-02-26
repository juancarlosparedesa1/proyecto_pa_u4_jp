package com.example.demo.funcional;

import java.util.List;

@FunctionalInterface
public interface IPersonaSupplier <T>  {
	//genericos en java letra
	public T getNombre();
}
