package com.boku.codingassignment.SalesTaxProblem;

public class BasicSalesTax implements Tax {

	private double taxPercent;

	public BasicSalesTax(double taxPercent) {
		this.taxPercent = taxPercent;
	}

	public double applyTaxes(PurchaseItem item) {
		double taxAmount = item.getPrice() * taxPercent/100;
		return taxAmount;
	}

}
