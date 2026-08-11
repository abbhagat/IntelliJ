package lld.splitwise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Split {
  private User user;
  private double amount;
}