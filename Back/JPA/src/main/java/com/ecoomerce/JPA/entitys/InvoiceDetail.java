package com.ecoomerce.JPA.entitys;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbldetalle_factura")
public class InvoiceDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_det_fac")
	private int id;
	@Column(name = "id_factura")
	private UUID factura;
	@Column(name = "id_producto")
	private int producto;
	@Column(name = "id_color")
	private int color;
	@Column(name = "id_talla")
	private int talla;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "total_producto")
	private float total;
	
	public InvoiceDetail() {
		
	}

	public InvoiceDetail(int id, UUID factura, int producto, int color, int talla, int cantidad, float total) {
		super();
		this.id = id;
		this.factura = factura;
		this.producto = producto;
		this.color = color;
		this.talla = talla;
		this.cantidad = cantidad;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UUID getFactura() {
		return factura;
	}

	public void setFactura(UUID factura) {
		this.factura = factura;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "InvoiceDetail [id=" + id + ", factura=" + factura + ", producto=" + producto + ", color=" + color
				+ ", talla=" + talla + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
}
