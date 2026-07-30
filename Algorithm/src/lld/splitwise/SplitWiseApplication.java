package lld.splitwise;

import java.util.*;

public class SplitWiseApplication {

  public static void main(String[] args) {
    //-------------------------
    // Create Users
    //-------------------------
    User alice   = new User("U1", "Alice", "alice@test.com", "9999999991");
    User bob     = new User("U2", "Bob",       "bob@test.com", "9999999992");
    User charlie = new User("U3", "Charlie", "charlie@test.com", "9999999993");
    //-------------------------
    // Expense Service
    //-------------------------
    BalanceSheet balanceSheet = new BalanceSheet();
    balanceSheet.setBalanceSheet(new HashMap<>());
    ExpenseService expenseService = new ExpenseService(balanceSheet);

    /****************************************************
     *               EQUAL SPLIT
     ****************************************************/
    EqualSplit equalSplit1 = new EqualSplit();
    equalSplit1.setUser(alice);

    EqualSplit equalSplit2 = new EqualSplit();
    equalSplit2.setUser(bob);

    EqualSplit equalSplit3 = new EqualSplit();
    equalSplit3.setUser(charlie);

    Expense equalExpense = new Expense();
    equalExpense.setExpenseId("EXP-1");
    equalExpense.setDescription("Dinner");
    equalExpense.setAmount(3000);
    equalExpense.setPaidBy(alice);
    equalExpense.setType(ExpenseType.EQUAL);
    equalExpense.setSplits(Arrays.asList(equalSplit1, equalSplit2, equalSplit3));

    expenseService.addExpense(equalExpense);

    System.out.println("\nAfter Equal Split");
    printBalanceSheet(balanceSheet);

    /****************************************************
     *               EXACT SPLIT
     ****************************************************/

    ExactSplit e1 = new ExactSplit();
    e1.setUser(alice);
    e1.setAmount(1200);

    ExactSplit e2 = new ExactSplit();
    e2.setUser(bob);
    e2.setAmount(1000);

    ExactSplit e3 = new ExactSplit();
    e3.setUser(charlie);
    e3.setAmount(800);

    Expense exactExpense = new Expense();
    exactExpense.setExpenseId("EXP-2");
    exactExpense.setDescription("Hotel");
    exactExpense.setAmount(3000);
    exactExpense.setPaidBy(bob);
    exactExpense.setType(ExpenseType.EXACT);
    exactExpense.setSplits(Arrays.asList(e1, e2, e3));

    expenseService.addExpense(exactExpense);

    System.out.println("\nAfter Exact Split");
    printBalanceSheet(balanceSheet);
    /****************************************************
     *            Settle Up
     ****************************************************/
    expenseService.settleUp(charlie, alice, 200);
    System.out.println("\nAfter Charlie pays Alice Rs.200");
    printBalanceSheet(balanceSheet);
  }

  private static void printBalanceSheet(BalanceSheet balanceSheet) {
    System.out.println("-------------------------------------");
    for (Map.Entry<String, Map<String, Double>> user :
        balanceSheet.getBalanceSheet().entrySet()) {
      System.out.println(user.getKey());
      for (Map.Entry<String, Double> balance :
          user.getValue().entrySet()) {
        System.out.printf("   %-5s : %.2f%n",
            balance.getKey(),
            balance.getValue());
      }
    }
    System.out.println("-------------------------------------");
  }
}