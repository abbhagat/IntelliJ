package lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class ExactSplit extends Split {

  @Override
  public void validateExpense(Expense expense) {
//    if (expense.getSplits() == null || expense.getSplits().isEmpty()) {
//      throw new RuntimeException("Exact split amounts are required");
//    }
//    double total = expense.getSplits()
//        .stream()
//        .mapToDouble(Split::getAmount)
//        .sum();
//    if (Double.compare(total, expense.getAmount()) != 0) {
//      throw new RuntimeException("Invalid Exact Split");
//    }
  }

  @Override
  public void splitExpense(Expense expense) {
    List<User> members = expense.getGroup().getUsers();
    List<Split> exactSplits = new ArrayList<>();
    double perUser   = expense.getAmount() / members.size();
    for (User user : members) {
      ExactSplit exactSplit = new ExactSplit();
      exactSplit.setUser(user);
      exactSplit.setAmount(perUser);
      exactSplits.add(exactSplit);
    }
    expense.setSplits(exactSplits);
  }
}
