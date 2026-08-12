package lld.splitwise;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Group {

  private final String groupId;
  private final String groupName;
  private final List<User> members;
  private final List<Expense> expenses;

  public Group(String groupId, String groupName) {
    this.groupId = groupId;
    this.groupName = groupName;
    this.members = new ArrayList<>();
    this.expenses = new ArrayList<>();

  }

  public void addMember(User user) {
    members.add(user);
  }

  public void addExpense(Expense expense) {
    expenses.add(expense);
  }
}
