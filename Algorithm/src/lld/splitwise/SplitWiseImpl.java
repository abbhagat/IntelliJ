package lld.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    BalanceSheet balanceSheet = new BalanceSheet(new HashMap<>());

    ExpenseService expenseService = new ExpenseService(balanceSheet);

    // 1. EQUAL SPLIT

    Expense equalExpense = new Expense();

    equalExpense.setExpenseId("EXP-1");
    equalExpense.setDescription("Dinner");
    equalExpense.setAmount(3000);
    equalExpense.setPaidBy(alice);
    equalExpense.setExpenseType(ExpenseType.EQUAL);
    equalExpense.setGroup(group);

    expenseService.addExpense(equalExpense);

    System.out.println("EQUAL SPLIT");
    printSplits(equalExpense);

    // BALANCE SHEET
    System.out.println("\nBALANCE SHEET");
    printBalanceSheet(balanceSheet);

    // 2. EXACT SPLIT

    Expense exactExpense = new Expense();

    exactExpense.setExpenseId("EXP-2");
    exactExpense.setDescription("Hotel");
    exactExpense.setAmount(6000);
    exactExpense.setPaidBy(bob);
    exactExpense.setExpenseType(ExpenseType.EXACT);
    exactExpense.setGroup(group);

    List<Split> exactSplits = new ArrayList<>();

    ExactSplit aliceExact = new ExactSplit();
    aliceExact.setUser(alice);
    aliceExact.setAmount(2000);

    ExactSplit bobExact = new ExactSplit();
    bobExact.setUser(bob);
    bobExact.setAmount(2000);

    ExactSplit charlieExact = new ExactSplit();
    charlieExact.setUser(charlie);
    charlieExact.setAmount(2000);

    exactSplits.add(aliceExact);
    exactSplits.add(bobExact);
    exactSplits.add(charlieExact);

    exactExpense.setSplits(exactSplits);

    expenseService.addExpense(exactExpense);

    System.out.println("EXACT SPLIT");
    printSplits(exactExpense);

    // BALANCE SHEET
    System.out.println("\nBALANCE SHEET");
    printBalanceSheet(balanceSheet);

    // 3. PERCENT SPLIT

    Expense percentExpense = new Expense();

    percentExpense.setExpenseId("EXP-3");
    percentExpense.setDescription("Shopping");
    percentExpense.setAmount(10000);
    percentExpense.setPaidBy(charlie);
    percentExpense.setExpenseType(ExpenseType.PERCENT);
    percentExpense.setGroup(group);

    List<Split> percentSplits = new ArrayList<>();

    PercentSplit alicePercent = new PercentSplit();
    alicePercent.setUser(alice);
    alicePercent.setPercent(20);

    PercentSplit bobPercent = new PercentSplit();
    bobPercent.setUser(bob);
    bobPercent.setPercent(30);

    PercentSplit charliePercent = new PercentSplit();
    charliePercent.setUser(charlie);
    charliePercent.setPercent(50);

    percentSplits.add(alicePercent);
    percentSplits.add(bobPercent);
    percentSplits.add(charliePercent);

    percentExpense.setSplits(percentSplits);

    expenseService.addExpense(percentExpense);

    System.out.println("PERCENT SPLIT");
    printSplits(percentExpense);

    // BALANCE SHEET
    System.out.println("\nBALANCE SHEET");
    printBalanceSheet(balanceSheet);

    // SETTLE UP

    expenseService.settleUp(bob, alice, 1000);
    expenseService.settleUp(charlie, alice, 1000);

    // AFTER SETTLEMENT
    System.out.println("After settlement:");
    printBalanceSheet(balanceSheet);
  }


  private static void printSplits(Expense expense) {
    for (Split split : expense.getSplits()) {
      System.out.printf("%-8s : %.2f%n", split.getUser().name(), split.getAmount()
      );
    }
    System.out.println();
  }

  private static void printBalanceSheet(
      BalanceSheet balanceSheet) {
    System.out.println("-------------------------------------");
    for (Map.Entry<String, Map<String, Double>> user : balanceSheet.balanceSheet().entrySet()) {
      System.out.println(user.getKey());
      for (Map.Entry<String, Double> balance : user.getValue().entrySet()) {
        System.out.printf("%-5s : %.2f%n", balance.getKey(), balance.getValue()
        );
      }
    }
    System.out.println("-------------------------------------");
  }
}
