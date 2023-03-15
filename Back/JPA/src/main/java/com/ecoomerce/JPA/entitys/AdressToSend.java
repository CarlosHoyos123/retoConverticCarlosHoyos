package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tbldirecciones_envio")
public class AdressToSend {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id_direccion_envio")
	private int id;
	@Column(name ="direccion")
	private String direccion;
	@Column(name ="zip_code")
	private String zipCode;
	@Column(name ="id_cliente")
	private int cliente;
	@Column(name ="id_pais")
	private int pais;

	public AdressToSend () {
		
	}
	
	public AdressToSend(String direccion, String zipCode, int cliente, int pais) {
		super();
		this.direccion = direccion;
		this.zipCode = zipCode;
		this.cliente = cliente;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Envio [id=" + id + ", direccion=" + direccion + ", zipCode=" + zipCode + ", cliente=" + cliente
				+ ", pais=" + pais + "]";
	}
	
}
