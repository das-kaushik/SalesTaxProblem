package com.boku.codingassignment.SalesTaxProblem;

public class ImportDutyTax implements ITax {
	private double taxPercent;

	public ImportDutyTax(double taxPercent) {
		this.taxPercent = taxPercent;
	}

	public double applyTaxes(PurchaseItem item) {
		double taxAmount = item.getPrice() * taxPercent / 100;
		return taxAmount;
	}

}
