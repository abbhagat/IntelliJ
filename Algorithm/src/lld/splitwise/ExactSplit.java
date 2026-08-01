package lld.splitwise;

public class ExactSplit extends Split implements IExpense {

  public void validate(Expense expense) {
    double total = expense.getSplits()
                          .stream()
                          .mapToDouble(Split::getAmount).sum();
    if (total != expense.getAmount()) {
      throw new RuntimeException("Invalid Exact Split");
    }
  }

  @Override
  public void splitExpense(Expense expense) {

  }
}
