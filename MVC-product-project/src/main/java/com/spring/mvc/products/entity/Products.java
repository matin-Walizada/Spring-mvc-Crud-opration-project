package com.spring.mvc.products.entity;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// this is an Entity class
	public class Products {
	// we have 4 fields
	private int id;
	private String name;
	private String brand;
	private Timestamp doe;
	 

	// create no argument constructo

	public Products() {

	}

	// create parameterized constructor
	public Products(int id, String name, String brand, Timestamp doe, MultipartFile[] file, List<Integer> cimageIds) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.doe = doe;
		 
	}

	// create getters and setters of our fields
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", brand=" + brand + ", doe=" + doe + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getBrand()=" + getBrand() + ", getDoe()=" + getDoe() + "]";
	}

	 

	// create toString method()
	
	

}
