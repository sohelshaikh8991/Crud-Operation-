package com.NimapInfotech.Nimap.ProductDto;

public class ProductDto {

	private long ProductId;
	
	private String ProductName;
	
	private long ProductPrice;
	
	private long categoryId;

	public long getProductId() {
		return ProductId;
	}

	public void setProductId(long productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public long getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(long productPrice) {
		ProductPrice = productPrice;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	
}
