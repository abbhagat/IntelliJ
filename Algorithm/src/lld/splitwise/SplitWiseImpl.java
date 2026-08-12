package lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class SplitWiseImpl {

  public static void main(String[] args) {

    User alice   = new User("U1", "Alice", "alice@test.com", "9999999991");
    User bob     = new User("U2", "Bob", "bob@test.com", "9999999992");
    User charlie = new User("U3", "Charlie", "charlie@test.com", "9999999993");

    Group group = new Group("G1", "Goa Trip");

    group.addMember(alice);
    group.addMember(bob);
    group.addMember(charlie);

    // Expense Service
    BalanceSheet balanceSheet = new BalanceSheet(new HashMap<>());

    ExpenseService expenseService = new ExpenseService(balanceSheet);

    // Equal Expense
    Expense expense = new Expense();
    expense.setExpenseId("EXP-1");
    expense.setDescription("Dinner");
    expense.setAmount(3000);
    expense.setPaidBy(alice);
    expense.setExpenseType(ExpenseType.EQUAL);
    expense.setGroup(group);

    expenseService.addExpense(expense);

    printBalanceSheet(balanceSheet);
  }

  private static void printBalanceSheet(BalanceSheet balanceSheet) {
    System.out.println("-------------------------------------");
    for (Map.Entry<String, Map<String, Double>> user : balanceSheet.getBalanceSheet().entrySet()) {
      System.out.println(user.getKey());
      for (Map.Entry<String, Double> balance : user.getValue().entrySet()) {
        System.out.printf("   %-5s : %.2f%n", balance.getKey(), balance.getValue());
      }
    }
    System.out.println("-------------------------------------");
  }
}
