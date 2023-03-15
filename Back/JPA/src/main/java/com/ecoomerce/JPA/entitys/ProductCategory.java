package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblcategorias_producto")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cat_prod")
	private int id;
	@Column(name="ID_categoria")
	private int categoria;
	@Column(name="ID_producto")
	private int producto;
	
	public ProductCategory() {
		
	}

	public ProductCategory(int categoria, int producto) {
		super();
		this.categoria = categoria;
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "CategoriasProducto [id=" + id + ", categoria=" + categoria + ", producto=" + producto + "]";
	}
}
