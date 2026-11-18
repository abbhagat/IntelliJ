package lld.splitwise;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Expense {

  private String expenseId;
  private String description;
  private User paidBy;
  private double amount;
  private List<Split> splits;
  private ExpenseType expenseType;
  private Group group;

}
