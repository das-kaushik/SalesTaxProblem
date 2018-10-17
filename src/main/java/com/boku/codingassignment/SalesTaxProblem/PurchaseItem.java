package com.boku.codingassignment.SalesTaxProblem;

import java.util.List;

public class PurchaseItem {
	private String description;
	private int quantity;
	private List<ITax> applicableTaxes;
	private double price;
	private double salesPrice;
	private boolean isImported;
	private Category category;

	public PurchaseItem(String description, int quantity, double price, boolean isImported, Category category) {
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.isImported = isImported;
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<ITax> getApplicableTaxes() {
		return applicableTaxes;
	}

	public void setApplicableTaxes(List<ITax> applicableTaxes) {
		this.applicableTaxes = applicableTaxes;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
