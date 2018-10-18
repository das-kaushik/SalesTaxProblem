package com.boku.codingassignment.SalesTaxProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class PurchaseItemFactory {

	private static final String MEDICINE = "medicine";
	private static final String TABLETS = "tablets";
	private static final String PILLS = "pills";
	private static final String CHOCOLATE = "chocolate";
	private static final String BOOK = "book";
	private static Set<Tax> availableTaxes = null;
	private static Map<Tax, Predicate<PurchaseItem>> applicableTaxToProductMap = null;

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
		applicableTaxToProductMap.put(basicSalesTax, x -> !basicSalesTaxExemptedcategories.contains(x.getCategory()));
		applicableTaxToProductMap.put(importDutyTax, y -> y.isImported());
	}

	public static PurchaseItem createPurchaseItem(String name, int quantity, boolean isImported, double price)
			throws InvalidInputException {
		Category productCategory = getProductCategory(name);
		PurchaseItem purchaseItem = new PurchaseItem(name, quantity, price, isImported, productCategory);
		if (!purchaseItem.isValid())
			throw new InvalidInputException("");
		purchaseItem.setSalesTax(purchaseItem.getPrice());
		List<Tax> applicableTaxes = new ArrayList<>();
		for (Tax tax : availableTaxes) {
			Predicate<PurchaseItem> predicate = applicableTaxToProductMap.get(tax);
			if (predicate != null && predicate.test(purchaseItem)) {
				applicableTaxes.add(tax);
			}
		}
		purchaseItem.addApplicableTaxes(applicableTaxes);
		return purchaseItem;
	}

	private static Category getProductCategory(String name) {
		String nameInLowerCase = name.toLowerCase();
		if (nameInLowerCase.contains(BOOK))
			return Category.BOOKS;
		if (nameInLowerCase.contains(CHOCOLATE))
			return Category.FOOD;
		if (nameInLowerCase.contains(PILLS) || nameInLowerCase.contains(MEDICINE) || nameInLowerCase.contains(TABLETS))
			return Category.MEDICALPRODUCTS;
		return Category.OTHERS;

	}

}
