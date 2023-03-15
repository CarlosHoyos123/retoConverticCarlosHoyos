package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblpaises")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pais", nullable = true)
	private int id;
	@Column(name="nombre_pais")
	private String nombrePais;
	
	public Country() {
		
	}

	public Country(int id, String nombrePais) {
		super();
		this.id = id;
		this.nombrePais = nombrePais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombrePais=" + nombrePais + "]";
	}
	
}
