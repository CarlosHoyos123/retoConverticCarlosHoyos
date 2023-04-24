package com.ecoomerce.JPA.entitys;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tblshopping_car")
public class ShoppingCar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_car")
	private  int id;
	
	@Column(name="ID_cliente")
	private int cliente;

	@Column(name="fecha_creacion")
	private Date desde;

	@Column(name="ID_producto")
	private int producto;

	@Column(name="ID_talla")
	private int talla;

	@Column(name="ID_color")
	private int color;

	@Column(name="cantidad")
	private int cantidad;

	public ShoppingCar(int id, int cliente, Date desde, int producto, int talla, int color, int cantidad) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.desde = desde;
		this.producto = producto;
		this.talla = talla;
		this.color = color;
		this.cantidad = cantidad;
	}

	public ShoppingCar() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ShoppingCar [id=" + id + ", cliente=" + cliente + ", desde=" + desde + ", producto=" + producto
				+ ", talla=" + talla + ", color=" + color + ", cantidad=" + cantidad + "]";
	}
	
	
}
