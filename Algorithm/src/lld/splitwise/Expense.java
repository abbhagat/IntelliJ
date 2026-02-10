package lld.splitwise;

import java.util.List;

public abstract class Expense {
  String expenseId;
  String description;
  double amount;
  User paidBy;
  List<Split> splits;
  ExpenseType type;
}
