package com.example.demo.funcional;

public class Ciudadano {
	private String nombreCompleto;
	private String ciduad;
	
	//SET Y GET
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCiduad() {
		return ciduad;
	}
	public void setCiduad(String ciduad) {
		this.ciduad = ciduad;
	}
	//TO STRING
	@Override
	public String toString() {
		return "Ciudadano [nombreCompleto=" + nombreCompleto + ", ciduad=" + ciduad + "]";
	}
	
}
