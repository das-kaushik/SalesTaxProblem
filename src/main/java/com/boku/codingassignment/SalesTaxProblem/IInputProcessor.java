package com.boku.codingassignment.SalesTaxProblem;

import java.util.List;

public interface IInputProcessor {
	List<PurchaseItem> parseInput() throws InvalidInputException;
}
