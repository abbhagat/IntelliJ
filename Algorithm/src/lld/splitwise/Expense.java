package lld.splitwise;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Expense {
  private String expenseId;
  private String description;
  private double amount;
  private User paidBy;
  private List<Split> splits;
  private ExpenseType type;
}
