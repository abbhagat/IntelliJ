package lld.splitwise;

public class ExactSplit extends Split implements IExpense {

  @Override
  public void validateExpense(Expense expense) {

    double total = expense.getSplits()
        .stream()
        .mapToDouble(Split::getAmount)
        .sum();

    if (Double.compare(total, expense.getAmount()) != 0) {
      throw new RuntimeException("Invalid Exact Split");
    }
  }

  @Override
  public void splitExpense(Expense expense) {
    // Amounts are already provided for exact split.
  }
}