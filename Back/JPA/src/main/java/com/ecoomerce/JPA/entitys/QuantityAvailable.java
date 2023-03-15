package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblprod_color_talla")
public class QuantityAvailable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idcoloxtalla")
	private int id;
	@Column(name="ID_producto")
	private int producto;
	@Column(name="ID_color")
	private int color;
	@Column(name="ID_talla")
	private int talla;
	@Column(name="inventario")
	private int cantidad;
	
	public QuantityAvailable(){
		
	}

	public QuantityAvailable(int id, int producto, int color, int talla, int cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.color = color;
		this.talla = talla;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "QuantityAvailable [id=" + id + ", producto=" + producto + ", color=" + color + ", talla=" + talla
				+ ", cantidad=" + cantidad + "]";
	}
}
