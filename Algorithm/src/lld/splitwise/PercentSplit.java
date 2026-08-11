package lld.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentSplit implements SplitStrategy {

  private Map<User, Double> percentages;

  public PercentSplit() {}

  public PercentSplit(Map<User, Double> percentages) {
    this.percentages = percentages;
  }

  @Override
  public void validateExpense(Expense expense) {

    double total = percentages.values()
        .stream()
        .mapToDouble(Double::doubleValue)
        .sum();

    if (Double.compare(total, 100.0) != 0) {
      throw new RuntimeException(
          "Percentages must total 100");
    }
  }

  @Override
  public void calculateSplits(Expense expense) {

    List<Split> splits = new ArrayList<>();

    for (Map.Entry<User, Double> entry :
        percentages.entrySet()) {

      double amount =
          expense.getAmount()
              * entry.getValue()
              / 100;

      splits.add(
          new Split(entry.getKey(), amount)
      );
    }

    expense.setSplits(splits);
  }
}
