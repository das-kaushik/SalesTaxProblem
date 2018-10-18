package com.boku.codingassignment.SalesTaxProblem;

import java.util.ArrayList;
import java.util.List;

public class PurchaseItem {
	private String description;
	private int quantity;
	private List<Tax> applicableTaxes;
	private double price;
	private double salesTax;
	private boolean isImported;
	private Category category;

	protected PurchaseItem(String description, int quantity, double price, boolean isImported, Category category) {
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

	public List<Tax> getApplicableTaxes() {
		if (applicableTaxes == null)
			applicableTaxes = new ArrayList<>();
		return applicableTaxes;
	}

	public void addApplicableTaxes(List<Tax> applicableTaxes) {
		this.applicableTaxes = applicableTaxes;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesPrice) {
		this.salesTax = salesPrice;
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

	public boolean isValid() {
		return this.quantity > 0 && this.price >= 0 && this.salesTax >= 0 && this.description.length() > 0;
	}

}
