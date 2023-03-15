package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblopciones")
public class Opciones {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_opcion")
	private int id;
	@Column(name="nombre_opcion")
	private String nombre;
	@Column(name="descripcion_opcion")
	private String descripcion;
	
	public Opciones() {
		
	}

	public Opciones(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Opciones [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
