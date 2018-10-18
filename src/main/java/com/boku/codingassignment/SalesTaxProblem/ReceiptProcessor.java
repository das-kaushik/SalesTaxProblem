package com.boku.codingassignment.SalesTaxProblem;

import java.util.List;

public class ReceiptProcessor {

	public void generateReceipt(List<PurchaseItem> purchaseItems) {
		StringBuilder receipt = new StringBuilder();
		double totalTaxPaid = 0.0;
		double totalAmountPaid = 0.0;
		for (PurchaseItem item : purchaseItems) {
			totalTaxPaid += item.getSalesTax();
			totalAmountPaid += item.getSalesTax() + item.getPrice();
			receipt.append(item.getQuantity() + " " + (item.isImported() ? "imported " : "") + item.getDescription()
					+ ":" + " " + String.format("%.2f", (item.getSalesTax() + item.getPrice())))
					.append(System.lineSeparator());
		}
		receipt.append("Sales Taxes: " + String.format("%.2f", totalTaxPaid)).append(System.lineSeparator());
		receipt.append("Total: " + String.format("%.2f", totalAmountPaid));
		System.out.println(receipt.toString());
	}
}
