package com.ecoomerce.JPA.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tblcolor")
public class Color {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_color")
	private int id;
	@Column(name="color")
	private String color;
	@Column(name="hexadecimal")
	private String hexadecimal;
	
	public Color() {
		
	}

	public Color(String color, String hexadecimal) {
		super();
		this.color = color;
		this.hexadecimal = hexadecimal;
	}

	public int getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

	public String getHexadecimal() {
		return hexadecimal;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", color=" + color + ", hexadecimal=" + hexadecimal + "]";
	}
	
	
}
