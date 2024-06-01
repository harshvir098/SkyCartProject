package com.entity;

public class Product {

	private int id;

	private String title;

	private String description;

	private String category;

	private String price;

	private int stock;

	private String image;

	private int discount;

	private Double discountBeforePrice;

	public Product(int id, String title, String description, String category, String price, int stock, String image) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}

	public Product() {
		super();
	}

	public Product(String title, String description, String category, String price, int stock, String image) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}

	public Double getDiscountBeforePrice() {
		return discountBeforePrice;
	}

	public void setDiscountBeforePrice(Double discountBeforePrice) {
		this.discountBeforePrice = discountBeforePrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
