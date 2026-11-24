package lld.splitwise;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Group {

  private final String id;
  private final String name;
  private final List<User> users;
  private final List<Expense> expenses;

  public Group(String id, String name) {
    this.id       = id;
    this.name     = name;
    this.users = new ArrayList<>();
    this.expenses = new ArrayList<>();
  }

  public void addMember(User user) {
    this.users.add(user);
  }

  public void addExpense(Expense expense) {
    this.expenses.add(expense);
  }

}
