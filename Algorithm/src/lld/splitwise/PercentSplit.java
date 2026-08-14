package lld.splitwise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentSplit extends Split {

  private double percent;

  @Override
  public void validateExpense(Expense expense) {
    if (expense.getSplits() == null || expense.getSplits().isEmpty()) {
      throw new RuntimeException("Percentage splits are required");
    }
    double totalPercent = expense.getSplits()
                                 .stream()
                                 .mapToDouble(split -> ((PercentSplit) split).getPercent())
                                 .sum();
    if (Double.compare(totalPercent, 100.0) != 0) {
      throw new RuntimeException("Percentages must add up to 100");
    }
  }

  @Override
  public void splitExpense(Expense expense) {
    for (Split split : expense.getSplits()) {
      PercentSplit percentSplit = (PercentSplit) split;
      double amount = expense.getAmount() * percentSplit.getPercent() / 100;
      percentSplit.setAmount(amount);
    }
  }
}
