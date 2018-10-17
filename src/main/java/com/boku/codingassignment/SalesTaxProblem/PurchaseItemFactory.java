package com.boku.codingassignment.SalesTaxProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class PurchaseItemFactory {

	private static Set<ITax> availableTaxes = null;
	private static Map<ITax, Predicate<PurchaseItem>> applicableTaxToProductMap = null;

	static {
		intialize();
	}

	private static void intialize() {
		availableTaxes = new HashSet<>();
		applicableTaxToProductMap = new HashMap<>();
		BasicSalesTax basicSalesTax = new BasicSalesTax(10);
		ImportDutyTax importDutyTax = new ImportDutyTax(5);
		availableTaxes.add(basicSalesTax);
		availableTaxes.add(importDutyTax);
		List<Category> basicSalesTaxExemptedcategories = new ArrayList<>();
		basicSalesTaxExemptedcategories.add(Category.BOOKS);
		basicSalesTaxExemptedcategories.add(Category.FOOD);
		basicSalesTaxExemptedcategories.add(Category.MEDICALPRODUCTS);
		applicableTaxToProductMap.put(basicSalesTax,
				x -> !basicSalesTaxExemptedcategories.contains(x.getCategory()));
		applicableTaxToProductMap.put(importDutyTax, y -> y.isImported());
	}

	public static PurchaseItem createPurchaseItem(String name, int quantity, boolean isImported, double price) {
		Category productCategory = getProductCategory(name);
		PurchaseItem purchaseItem = new PurchaseItem(name, quantity, price, isImported, productCategory);
		purchaseItem.setSalesPrice(purchaseItem.getPrice());
		List<ITax> applicableTaxes = new ArrayList<>();
		for (ITax tax : availableTaxes) {
			Predicate<PurchaseItem> predicate = applicableTaxToProductMap.get(tax);
			if (predicate != null && predicate.test(purchaseItem)) {
				applicableTaxes.add(tax);
			}
		}
		purchaseItem.setApplicableTaxes(applicableTaxes);
		return purchaseItem;
	}

	private static Category getProductCategory(String name) {
		if (name.contains("book"))
			return Category.BOOKS;
		if (name.contains("chocolate"))
			return Category.FOOD;
		if (name.contains("pills"))
			return Category.MEDICALPRODUCTS;
		return Category.OTHERS;

	}

}
