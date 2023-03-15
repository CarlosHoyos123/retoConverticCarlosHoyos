package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tblcategorias")
public class Category {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_categoria")
	private int id;
	@Column(name ="nombre")
	private String nombre;
	@Column(name ="descripcion")
	private String descripcion;
	
	public Category() {
		
	}
	
	public Category(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
