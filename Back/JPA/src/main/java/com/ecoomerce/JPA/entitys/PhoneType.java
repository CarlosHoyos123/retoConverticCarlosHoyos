package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbltipo_telefono")
public class PhoneType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tipo_telefono")
	private int id;
	@Column(name = "tipo_telefono")
	private String tipoTelefono;
	
	public PhoneType() {
		
	}

	public PhoneType(int id, String tipoTelefono) {
		super();
		this.id = id;
		this.tipoTelefono = tipoTelefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	@Override
	public String toString() {
		return "TipoTelefono [id=" + id + ", tipoTelefono=" + tipoTelefono + "]";
	}
}
