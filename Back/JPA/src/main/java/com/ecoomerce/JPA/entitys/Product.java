package com.ecoomerce.JPA.entitys;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@NamedStoredProcedureQuery(
		name = "filtrarresultados",
		procedureName = "filtrarresultados",
		resultClasses = { Product.class }, 
		parameters = {
				@StoredProcedureParameter(mode=ParameterMode.IN, name= "aBuscar", type=String.class)
		})
@Table(name="tblproductos")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int id;
	@Column(name="plu")
	private String plu;
	@Column(name="nombre_producto")
	private String producto;
	@Column(name="id_fabricante")
	private int fabricante;
	@Column(name="precio")
	private float precio;
	@Column(name="descripcion_producto")
	private String descripcion;
	@Column(name="fecha_creacion")
	private Date desde;
	@Column(name="id_genero")
	private int genero;
	@Column(name="cantidad_busquedas")
	private int busquedas;
	@Column(name = "fotos")
	private String rutaFoto;
	
	public Product() {
		
	}

	public Product(int id, String plu, String producto, int fabricante, float precio, String descripcion, Date desde,
			int genero, int busquedas, String rutaFoto) {
		super();
		this.id = id;
		this.plu = plu;
		this.producto = producto;
		this.fabricante = fabricante;
		this.precio = precio;
		this.descripcion = descripcion;
		this.desde = desde;
		this.genero = genero;
		this.busquedas = busquedas;
		this.rutaFoto = rutaFoto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlu() {
		return plu;
	}

	public void setPlu(String plu) {
		this.plu = plu;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getFabricante() {
		return fabricante;
	}

	public void setFabricante(int fabricante) {
		this.fabricante = fabricante;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public int getBusquedas() {
		return busquedas;
	}

	public void setBusquedas(int busquedas) {
		this.busquedas = busquedas;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", plu=" + plu + ", producto=" + producto + ", fabricante=" + fabricante
				+ ", precio=" + precio + ", descripcion=" + descripcion + ", desde=" + desde + ", genero=" + genero
				+ ", busquedas=" + busquedas + ", rutaFoto=" + rutaFoto + "]";
	}
	
}
