package com.example.demo.funcional;

public class PersonaSupplier2Impl implements IPersonaSupplier<Persona> {

	@Override
	public Persona getNombre() {
		Persona per = new Persona();
		per.setApellido("Paredes");
		per.setNombre("juan");
		return per; 
		
	}

}
