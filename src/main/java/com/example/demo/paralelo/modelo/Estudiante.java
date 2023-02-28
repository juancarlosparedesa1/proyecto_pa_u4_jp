package com.example.demo.paralelo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante_p")
public class Estudiante {
	
	@Id
	@SequenceGenerator(name = "seq_estu",sequenceName = "seq_estu",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_estu")
	@Column(name = "estu_id")
	private Integer id;
	@Column(name = "estu_nombre_completo")
	private String nombreCompleto;
	@Column(name = "estu_edad")
	private Integer edad;
	
	//set and get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	//to string
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombreCompleto=" + nombreCompleto + ", edad=" + edad + "]";
	}
	
	
}