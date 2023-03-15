package com.ecoomerce.JPA.utils;

import java.util.List;

import com.ecoomerce.JPA.entitys.Color;
import com.ecoomerce.JPA.entitys.QuantityAvailable;
import com.ecoomerce.JPA.entitys.Size;

public class detailResponse {

	
	private List<QuantityAvailable> quantityAvailable;
	private List<Color> colorsAvailable;
	private List<Size>  sizesAvailable;
	private ProductDetailed productInfo;
	public detailResponse(List<QuantityAvailable> quantityAvailable, List<Color> colorsAvailable,
			List<Size> sizesAvailable, ProductDetailed productInfo) {
		super();
		this.quantityAvailable = quantityAvailable;
		this.colorsAvailable = colorsAvailable;
		this.sizesAvailable = sizesAvailable;
		this.productInfo = productInfo;
	}
	public List<QuantityAvailable> getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(List<QuantityAvailable> quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public List<Color> getColorsAvailable() {
		return colorsAvailable;
	}
	public void setColorsAvailable(List<Color> colorsAvailable) {
		this.colorsAvailable = colorsAvailable;
	}
	public List<Size> getSizesAvailable() {
		return sizesAvailable;
	}
	public void setSizesAvailable(List<Size> sizesAvailable) {
		this.sizesAvailable = sizesAvailable;
	}
	public ProductDetailed getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductDetailed productInfo) {
		this.productInfo = productInfo;
	}
	@Override
	public String toString() {
		return "detailResponse [quantityAvailable=" + quantityAvailable + ", colorsAvailable=" + colorsAvailable
				+ ", sizesAvailable=" + sizesAvailable + ", productInfo=" + productInfo + "]";
	}	
}
