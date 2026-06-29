package lld.splitwise;

public class EqualExpenseSplit implements ExpenseSplitStrategy {

  @Override
  public void validate(Expense expense) {
    System.out.println("Simulating Success Validation");
  }

  public void splitExpense(Expense expense) {
    double perUser = expense.getAmount() / expense.getSplits().size();
    for (Split split : expense.getSplits()) {
      split.amount = perUser;
    }
  }
}
