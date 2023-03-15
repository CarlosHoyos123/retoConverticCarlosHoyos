package com.ecoomerce.JPA.utils;

public class ProductForList {

	private int id;
	private String plu;
	private String producto;
	private Float precio;
	private String descripcion;
	private int genero;
	private String rutaFoto;
	
	public ProductForList() {
		
	}

	public ProductForList(int id, String plu, String producto, Float precio, String descripcion, int genero,
			String rutaFoto) {
		super();
		this.id = id;
		this.plu = plu;
		this.producto = producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.genero = genero;
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

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	@Override
	public String toString() {
		return "ProductForList [id=" + id + ", plu=" + plu + ", producto=" + producto + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", genero=" + genero + ", rutaFoto=" + rutaFoto + "]";
	}
	
}
