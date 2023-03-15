package com.ecoomerce.JPA.utils;

public class ProductDetailed {

    private String plu;
    private String nombre;
    private String fabricante;
    private Float precio;
    private String descripcion;
    private String rutaFoto;
    
    public ProductDetailed() {
    	
    }

	public ProductDetailed(String plu, String nombre, String fabricante, Float precio, String descripcion,
			String rutaFoto) {
		super();
		this.plu = plu;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.precio = precio;
		this.descripcion = descripcion;
		this.rutaFoto = rutaFoto;
	}

	public String getPlu() {
		return plu;
	}

	public void setPlu(String plu) {
		this.plu = plu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
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

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	@Override
	public String toString() {
		return "ProductDetailed [plu=" + plu + ", nombre=" + nombre + ", fabricante=" + fabricante + ", precio="
				+ precio + ", descripcion=" + descripcion + ", rutaFoto=" + rutaFoto + "]";
	}
}
