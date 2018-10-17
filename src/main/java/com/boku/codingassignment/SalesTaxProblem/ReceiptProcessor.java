package com.boku.codingassignment.SalesTaxProblem;

import java.util.List;

public class ReceiptProcessor {

	public void generateReceipt(List<PurchaseItem> purchaseItems, double totalTax) {
		StringBuilder receipt = new StringBuilder();
		double totalSalesPrice = 0.0f;
		for (PurchaseItem item : purchaseItems) {
			receipt.append(item.getQuantity() + " " + (item.isImported() ? "imported " : "") + item.getDescription()
					+ ":" + " " + String.format("%.2f", item.getSalesPrice())).append(System.lineSeparator());
			totalSalesPrice += item.getSalesPrice();
		}
		receipt.append("Sales Taxes: " + String.format("%.2f", totalTax)).append(System.lineSeparator());
		receipt.append("Total: " + String.format("%.2f", totalSalesPrice));
		System.out.println(receipt.toString());
	}
}
