package lld.splitwise;

public class EqualExpenseSplit implements ExpenseSplitStrategy {
  @Override
  public void validate(Expense expense) {

  }

  public void splitExpense(Expense expense) {
    double perUser = expense.amount / expense.splits.size();
    for (Split split : expense.splits) {
      split.amount = perUser;
    }
  }
}
