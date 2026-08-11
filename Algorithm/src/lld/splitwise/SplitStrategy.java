package lld.splitwise;

public interface SplitStrategy {
  void validateExpense(Expense expense);
  void calculateSplits(Expense expense);
}
