package com.onlinestore.onlinestore.repository;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
    private long productId;

	@Column(name = "NAME")
    private String name;
	
	@Column(name = "PRICE")
    private int price;
	
	@Column(name = "TYPE")
    private String type;
	
	public Product() {
	}

	public Product(long productId, String name, int price, String type) {
		this.productId = productId;
	    this.name = name;
	    this.price = price;
	    this.type = type;
	}
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}   
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemQuantity{" +
				"productId='" + productId + '\'' +
				", name='" + name + '\'' +
				", price='" + price + '\'' +
				", type='" + type + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (o == null || getClass() != o.getClass()) 
			return false;
		Product that = (Product) o;
		return Objects.equals(productId, that.productId) &&
				Objects.equals(name, that.name)&&
				Objects.equals(price, that.price)&&
				Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, name, price, type);
	}
}