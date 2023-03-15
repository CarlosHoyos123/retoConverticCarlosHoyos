package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbltallas")
public class Size {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="id_talla")
	 private int id;
	 @Column(name="nombre")
	 private String nombre;
	 @Column(name="talla")
	 private String talla;
	 
	 public Size() {
		 
	 }

	public Size(String nombre, String talla) {
		super();
		this.nombre = nombre;
		this.talla = talla;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@Override
	public String toString() {
		return "Talla [id=" + id + ", nombre=" + nombre + ", talla=" + talla + "]";
	}	
}
