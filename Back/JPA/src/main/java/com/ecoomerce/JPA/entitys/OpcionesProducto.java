package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblopciones_producto")
public class OpcionesProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_op_prod")
	private int id;
	@Column(name="ID_opcion")
	private int opcion;
	@Column(name="ID_producto")
	private int producto;
	
	public OpcionesProducto() {
		
	}

	public OpcionesProducto(int opcion, int producto) {
		super();
		this.opcion = opcion;
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "OpcionesProducto [id=" + id + ", opcion=" + opcion + ", producto=" + producto + "]";
	}
}
