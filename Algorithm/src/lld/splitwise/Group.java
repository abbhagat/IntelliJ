package lld.splitwise;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Group {

  private String groupId;
  private String name;
  private List<User> members = new ArrayList<>();
  private List<Expense> expenses = new ArrayList<>();

  public void addMember(User user) {
    members.add(user);
  }

  public void addExpense(Expense expense) {
    expenses.add(expense);
  }
}