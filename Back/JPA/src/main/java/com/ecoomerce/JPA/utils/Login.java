package com.ecoomerce.JPA.utils;

public class Login {

	private String correo;
	private String clave;
	
	public Login() {
		
	}

	public Login(String correo, String clave) {
		super();
		this.correo = correo;
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Login [correo=" + correo + ", clave=" + clave + "]";
	}

	
}
