package unihelp;

import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
	private List<Double> incomes = new ArrayList<>();
	private List<Double> expenses = new ArrayList<>();

	public void addTransaction(double amount) {
		if (amount >= 0) {
			incomes.add(amount);
			System.out.println("Income added.");
		} else {
			expenses.add(-amount);
			System.out.println("Expense added.");
		}
	}

	public double getTotalIncome() {
		return incomes.stream().mapToDouble(Double::doubleValue).sum();
	}

	public double getTotalExpenses() {
		return expenses.stream().mapToDouble(Double::doubleValue).sum();
	}

	public double getBalance() {
		return getTotalIncome() - getTotalExpenses();
	}

	public void viewSummary() {
		double totalIncome = getTotalIncome();
		double totalExpense = getTotalExpenses();
		double balance = getBalance();

		System.out.println("\n=== Budget Summary ===");
		System.out.printf("Total Income: $%.2f\n", totalIncome);
		System.out.printf("Total Expenses: $%.2f\n", totalExpense);
		System.out.printf("Balance: $%.2f\n", balance);
	}
}
