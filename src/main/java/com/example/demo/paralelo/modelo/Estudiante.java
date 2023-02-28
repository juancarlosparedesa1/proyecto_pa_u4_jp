package com.example.demo.paralelo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante_p")
public class Estudiante {
	@Id // Primarykey
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estu")
	@SequenceGenerator(name = "Seq_estu", sequenceName = "seq_estu", allocationSize = 1)

	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_nombre_completo")
	private String nombre_completo;

	@Column(name = "estu_edad")
	private Integer edad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre_completo=" + nombre_completo + ", edad=" + edad + "]";
	}

	
	


	
	
}
