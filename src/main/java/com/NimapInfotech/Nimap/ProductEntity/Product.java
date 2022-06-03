package com.NimapInfotech.Nimap.ProductEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.NimapInfotech.Nimap.CategoryEntity.Category;
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ProductId;
	private String ProductName;
	private long ProductPrice;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_name", nullable = true)
	private Category category;

	public Product() {
		super();
	}

	public Product(long productId, String productName, long productPrice, Category category) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductPrice = productPrice;
		this.category = category;
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductPrice=" + ProductPrice
				+ ", category=" + category + "]";
	}

	
}
