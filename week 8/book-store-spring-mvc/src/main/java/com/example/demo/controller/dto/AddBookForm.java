package com.example.demo.controller.dto;

public class AddBookForm {
	
	private String title;
	private double price;

	public AddBookForm(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}

	public AddBookForm() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
