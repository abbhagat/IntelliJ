package lld.splitwise;

public interface IExpense {
  void validateExpense(Expense expense);
  void splitExpense(Expense expense);
}