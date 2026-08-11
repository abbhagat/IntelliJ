package lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements SplitStrategy {

  @Override
  public void validateExpense(Expense expense) {

    if (expense.getGroup() == null) {
      throw new RuntimeException(
          "Expense must belong to a group");
    }

    if (expense.getGroup().getUsers().isEmpty()) {
      throw new RuntimeException(
          "Group has no members");
    }
  }

  @Override
  public void calculateSplits(Expense expense) {
    List<User> groupMembers = expense.getGroup().getUsers();
    double amountPerUser = expense.getAmount() / groupMembers.size();
    List<Split> splits = new ArrayList<>();
    for (User user : groupMembers) {
      splits.add(new Split(user, amountPerUser));
    }
    expense.setSplits(splits);
  }
}
