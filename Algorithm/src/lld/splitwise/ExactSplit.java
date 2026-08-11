package lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class ExactSplit implements SplitStrategy {

  private List<Split> requestedSplits;

  public ExactSplit() {}

  public ExactSplit(List<Split> requestedSplits) {
    this.requestedSplits = requestedSplits;
  }

  @Override
  public void validateExpense(Expense expense) {

    double total = requestedSplits.stream()
        .mapToDouble(Split::getAmount)
        .sum();

    if (Double.compare(total, expense.getAmount()) != 0) {
      throw new RuntimeException(
          "Split amounts don't match expense amount");
    }
  }

  @Override
  public void calculateSplits(Expense expense) {
    expense.setSplits(new ArrayList<>(requestedSplits));
  }
}