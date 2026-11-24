package lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit extends Split {

  @Override
  public void validateExpense(Expense expense) {
    Group group = expense.getGroup();
    if (group == null) {
      throw new RuntimeException("Expense must belong to a group");
    }
    if (group.getUsers().isEmpty()) {
      throw new RuntimeException("Group has no members");
    }
  }

  @Override
  public void splitExpense(Expense expense) {
    Group group      = expense.getGroup();
    List<User> users = group.getUsers();
    double perUser   = expense.getAmount() / users.size();
    List<Split> splits = new ArrayList<>();
    for (User user : users) {
      Split split = new EqualSplit();
      split.setUser(user);
      split.setAmount(perUser);
      splits.add(split);
    }
    expense.setSplits(splits);
  }
}
