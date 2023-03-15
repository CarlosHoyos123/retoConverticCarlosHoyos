package com.ecoomerce.JPA.utils;

import com.ecoomerce.JPA.entitys.Color;
import com.ecoomerce.JPA.entitys.Product;
import com.ecoomerce.JPA.entitys.Size;

public class CarGridResponse {

	private int idCar;
	private Product producto;
	private Size talla;
	private Color color;
	private int cantidad;
	
	public CarGridResponse(int idCar, Product producto, Size talla, Color color, int cantidad) {
		super();
		this.idCar = idCar;
		this.producto = producto;
		this.talla = talla;
		this.color = color;
		this.cantidad = cantidad;
	}
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public Product getProducto() {
		return producto;
	}
	public void setProducto(Product producto) {
		this.producto = producto;
	}
	public Size getTalla() {
		return talla;
	}
	public void setTalla(Size talla) {
		this.talla = talla;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
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
		return "CarGridResponse [idCar=" + idCar + ", producto=" + producto + ", talla=" + talla + ", color=" + color
				+ ", cantidad=" + cantidad + "]";
	}
}
