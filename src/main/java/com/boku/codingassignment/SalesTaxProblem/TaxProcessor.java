package com.boku.codingassignment.SalesTaxProblem;

import java.util.List;

public class TaxProcessor {
	private static final double ROUND_OFF = 0.05;
	private IInputProcessor inputProcessor;
	private ReceiptProcessor receiptProcessor;

	public TaxProcessor(IInputProcessor inputProcessor, ReceiptProcessor receiptProcessor) {
		this.inputProcessor = inputProcessor;
		this.receiptProcessor = receiptProcessor;
	}

	public double process(List<PurchaseItem> purchaseItems) {
		double totalTax = 0.0f;
		for (PurchaseItem item : purchaseItems) {
			if (item.getApplicableTaxes() != null) {
				double appliedTax = 0;
				for (ITax tax : item.getApplicableTaxes()) {
					appliedTax += Util.roundOff(tax.applyTaxes(item), ROUND_OFF);
				}
				item.setSalesPrice(item.getPrice() + appliedTax);
				totalTax += appliedTax;
			}
		}
		return totalTax;
	}

	public void process() throws InvalidInputException {
		List<PurchaseItem> purchaseItems = inputProcessor.parseInput();
		double totaltax = process(purchaseItems);
		receiptProcessor.generateReceipt(purchaseItems, totaltax);
	}
}
