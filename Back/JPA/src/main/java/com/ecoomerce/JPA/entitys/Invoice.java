package com.ecoomerce.JPA.entitys;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblfacturas")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	@Column(name = "id_factura")
	private UUID id;
	@Column(name = "fecha_factura")
	private Date fecha;
	@Column(name = "id_cliente")
	private int cliente;
	@Column(name = "total_factura")
	private double total;
	@Column(name = "id_estado")
	private int estado;
	@Column(name = "id_direccion_envio")
	private int dir_envio;
	@Column(name = "id_direccion_facturacion")
	private int dir_facturacion;
	
	public Invoice() {
		
	}

	public Invoice(UUID id, Date fecha, int cliente, double total, int estado, int dir_envio, int dir_facturacion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.total = total;
		this.estado = estado;
		this.dir_envio = dir_envio;
		this.dir_facturacion = dir_facturacion;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getDir_envio() {
		return dir_envio;
	}

	public void setDir_envio(int dir_envio) {
		this.dir_envio = dir_envio;
	}

	public int getDir_facturacion() {
		return dir_facturacion;
	}

	public void setDir_facturacion(int dir_facturacion) {
		this.dir_facturacion = dir_facturacion;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", total=" + total + ", estado="
				+ estado + ", dir_envio=" + dir_envio + ", dir_facturacion=" + dir_facturacion + "]";
	}
		
}
