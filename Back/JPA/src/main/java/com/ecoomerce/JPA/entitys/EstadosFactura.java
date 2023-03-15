package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblestados_factura")
public class EstadosFactura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_estado")
	private int id;
	@Column(name="estado")
	private String estado;
	@Column(name="descripcion")
	private String descripcion;
	
	public EstadosFactura() {
		
	}

	public EstadosFactura(String estado, String descripcion) {
		super();
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getEstado() {
		return estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "EstadosFactura [id=" + id + ", estado=" + estado + ", descripcion=" + descripcion + "]";
	}
}
