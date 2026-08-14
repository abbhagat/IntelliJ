package lld.splitwise;

public class ExactSplit extends Split {

  @Override
  public void validateExpense(Expense expense) {

    if (expense.getSplits() == null || expense.getSplits().isEmpty()) {
      throw new RuntimeException("Exact split amounts are required");
    }

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
    // Amounts are already provided by the caller.
  }
}