package lld.splitwise;

public interface ExpenseSplitStrategy {
  void validate(Expense expense);

  void splitExpense(Expense expense);
}

