package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblfabricantes")
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_fabricante")
	private int id;
	@Column(name="nombre_fabricante")
	private String nombre;
	@Column(name="contacto_fabricante")
	private String contacto;
	@Column(name="telefono_fabricante")
	private String telefono;
	
	public Fabricante() {
		
	}

	public Fabricante(String nombre, String contacto, String telefono) {
		super();
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", nombre=" + nombre + ", contacto=" + contacto + ", telefono=" + telefono
				+ "]";
	}
}
