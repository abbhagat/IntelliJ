package lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit extends Split implements IExpense {

  @Override
  public void validateExpense(Expense expense) {
    if (expense.getGroup() == null) {
      throw new RuntimeException("Expense must belong to a group");
    }
    if (expense.getGroup().getMembers().isEmpty()) {
      throw new RuntimeException("Group has no members");
    }
  }

  @Override
  public void splitExpense(Expense expense) {
    List<User> members = expense.getGroup().getMembers();
    List<Split> splits = new ArrayList<>();
    double perUser = expense.getAmount() / members.size();
    for (User user : members) {
      EqualSplit split = new EqualSplit();
      split.setUser(user);
      split.setAmount(perUser);
      splits.add(split);
    }
    expense.setSplits(splits);
  }
}
