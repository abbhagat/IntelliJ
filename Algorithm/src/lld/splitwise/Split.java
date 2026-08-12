package lld.splitwise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Split {

  private User user;
  private double amount;

  abstract void validateExpense(Expense expense);
  abstract void splitExpense(Expense expense);

}
