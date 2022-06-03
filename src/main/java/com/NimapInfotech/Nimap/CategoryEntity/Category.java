package com.NimapInfotech.Nimap.CategoryEntity;

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

import com.NimapInfotech.Nimap.ProductEntity.Product;

@Entity
@Table( name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long CategoryId;
	private String CategoryName;
	private String CategoryDescription;
	
	public Category() {
		super();
	}

	public Category(long categoryId, String categoryName, String categoryDescription) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
		CategoryDescription = categoryDescription;
	}

	public long getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(long categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + ", CategoryDescription="
				+ CategoryDescription + "]";
	}    
}
