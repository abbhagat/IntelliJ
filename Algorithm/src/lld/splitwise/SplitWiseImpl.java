package lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class SplitWiseImpl {

  public static void main(String[] args) {

    User alice =
        new User("U1", "Alice", "alice@test.com", "9999999991");

    User bob =
        new User("U2", "Bob", "bob@test.com", "9999999992");

    User charlie =
        new User("U3", "Charlie", "charlie@test.com", "9999999993");


    // -------------------------
    // Create Group
    // -------------------------

    Group trip = new Group();
    trip.setGroupId("G1");
    trip.setName("Goa Trip");

    trip.addMember(alice);
    trip.addMember(bob);
    trip.addMember(charlie);


    // -------------------------
    // Expense Service
    // -------------------------

    BalanceSheet balanceSheet = new BalanceSheet();
    balanceSheet.setBalanceSheet(new HashMap<>());

    ExpenseService expenseService =
        new ExpenseService(balanceSheet);


    // -------------------------
    // Equal Expense
    // -------------------------

    Expense dinner = new Expense();

    dinner.setExpenseId("EXP-1");
    dinner.setDescription("Dinner");
    dinner.setAmount(3000);
    dinner.setPaidBy(alice);
    dinner.setExpenseType(ExpenseType.EQUAL);
    dinner.setGroup(trip);

    expenseService.addExpense(dinner);


    printBalanceSheet(balanceSheet);
  }

  private static void printBalanceSheet(
      BalanceSheet balanceSheet) {

    System.out.println("-------------------------------------");

    for (Map.Entry<String, Map<String, Double>> user :
        balanceSheet.getBalanceSheet().entrySet()) {

      System.out.println(user.getKey());

      for (Map.Entry<String, Double> balance :
          user.getValue().entrySet()) {

        System.out.printf(
            "   %-5s : %.2f%n",
            balance.getKey(),
            balance.getValue());
      }
    }

    System.out.println("-------------------------------------");
  }
}