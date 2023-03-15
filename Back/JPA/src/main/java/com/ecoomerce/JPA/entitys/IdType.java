package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tbltipo_documento")
public class IdType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_tipo_documento")
	private int id;
	@Column (name="tipo_documento")
	private String TipoDocumento;
	
	public IdType() {
		
	}

	public IdType(int id, String tipoDocumento) {
		super();
		this.id = id;
		TipoDocumento = tipoDocumento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return TipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		return "TipoDocumento [id=" + id + ", TipoDocumento=" + TipoDocumento + "]";
	}
}
