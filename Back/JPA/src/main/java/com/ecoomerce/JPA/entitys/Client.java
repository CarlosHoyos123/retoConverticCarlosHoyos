package com.ecoomerce.JPA.entitys;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblclientes")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id_cliente")
	private int cliente;
	
	@Column(name ="email", length = 30, unique = true)
	private String email;
	
	@Column(name ="contrasenia", length = 30)
	private String contrasenia;
	
	@Column(name ="primer_nombre", length = 15)
	private String primerNombre;
	
	@Column(name ="segundo_nombre", length = 15)
	private String segundoNombre;
	
	@Column(name ="primer_apellido", length = 15)
	private String primerApellido;
	
	@Column(name ="segundo_apellido", length = 15)
	private String segundoApellido;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipo_telefono")
	private PhoneType tipoTelefono;
	
	@Column(name ="telefono", length = 15)
	private String telefono;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="id_pais")
	private Country pais;
	
	@Column(name ="documento", length = 30)
	private String numeroDocumento;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_documento")
	private IdType tipoDocumento;
	
	public Client() {
		
	}

	public Client(String email, String contrasenia, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, PhoneType tipoTelefono, String telefono, Country pais, String numeroDocumento,
			IdType tipoDocumento) {
		super();
		this.email = email;
		this.contrasenia = contrasenia;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoTelefono = tipoTelefono;
		this.telefono = telefono;
		this.pais = pais;
		this.numeroDocumento = numeroDocumento;
		this.tipoDocumento = tipoDocumento;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public void setTipoTelefono(PhoneType tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setPais(Country pais) {
		this.pais = pais;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public void setTipoDocumento(IdType tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getCliente() {
		return cliente;
	}

	public String getEmail() {
		return email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public PhoneType getTipoTelefono() {
		return tipoTelefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public Country getPais() {
		return pais;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public IdType getTipoDocumento() {
		return tipoDocumento;
	}

	@Override
	public String toString() {
		return "Clientes [cliente=" + cliente + ", email=" + email + ", contraseña=" + contrasenia + ", primerNombre="
				+ primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", tipoTelefono=" + tipoTelefono + ", telefono=" + telefono
				+ ", pais=" + pais + ", numeroDocumento=" + numeroDocumento + ", tipoDocumento=" + tipoDocumento + "]";
	}
}
