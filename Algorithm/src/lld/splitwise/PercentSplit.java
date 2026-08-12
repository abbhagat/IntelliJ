package lld.splitwise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentSplit extends Split {

  private double percent;

  @Override
  public void validateExpense(Expense expense) { }

  @Override
  public void splitExpense(Expense expense) { }

}