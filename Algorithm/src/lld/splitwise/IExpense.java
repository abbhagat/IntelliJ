package lld.splitwise;

public interface IExpense {
  void validate(Expense expense);
  void splitExpense(Expense expense);
}
