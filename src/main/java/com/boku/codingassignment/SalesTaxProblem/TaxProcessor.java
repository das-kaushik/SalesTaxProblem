package com.boku.codingassignment.SalesTaxProblem;

import java.util.List;

public class TaxProcessor {
	private static final double ROUND_OFF = 0.05;

	public void process(List<PurchaseItem> purchaseItems) {

		for (PurchaseItem item : purchaseItems) {
			double appliedTax = 0;
			for (Tax tax : item.getApplicableTaxes()) {
				appliedTax += Util.roundOff(tax.applyTaxes(item), ROUND_OFF);
			}
			item.setSalesTax(appliedTax);
		}
	}

}
