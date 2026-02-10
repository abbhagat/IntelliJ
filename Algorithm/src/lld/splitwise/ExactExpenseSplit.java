package lld.splitwise;

public class ExactExpenseSplit implements ExpenseSplitStrategy {
  public void validate(Expense expense) {
    double total = expense.splits.stream()
        .mapToDouble(s -> s.amount).sum();
    if (total != expense.amount) {
      throw new RuntimeException("Invalid Exact Split");
    }
  }

  @Override
  public void splitExpense(Expense expense) {

  }
}

