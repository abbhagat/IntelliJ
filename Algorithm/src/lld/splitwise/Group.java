package lld.splitwise;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Group {
  private String groupId;
  private String name;
  private List<User> members;
  private List<Expense> expenses;
}
