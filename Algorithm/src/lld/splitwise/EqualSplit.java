package lld.splitwise;

import java.util.List;

public class EqualSplit extends Split implements IExpense {

  @Override
  public void validate(Expense expense) {
    System.out.println("Simulating Success Validation");
  }

  public void splitExpense(Expense expense) {
    List<Split> splits = expense.getSplits();
    double amount = expense.getAmount();
    double perUser = amount / splits.size();
    for (Split split : splits) {
      split.setAmount(perUser);
    }
  }
}
