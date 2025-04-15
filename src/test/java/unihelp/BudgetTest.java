package unihelp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BudgetTest {
	@Test
	void budgetManagerCalculations() {
		BudgetManager budgetManager = new BudgetManager();
		budgetManager.addTransaction(100.0);
		budgetManager.addTransaction(-40.0);
		budgetManager.addTransaction(-10.0);

		double totalIncome = budgetManager.getTotalIncome();
		double totalExpenses = budgetManager.getTotalExpenses();
		double balance = budgetManager.getBalance();

		assertEquals(100.0, totalIncome);
		assertEquals(50.0, totalExpenses);
		assertEquals(50.0, balance);
	}
}
