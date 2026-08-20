package lld.atm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {

  private final String accountNumber;
  private double balance;

  public boolean withdraw(double amount) {
    if (amount <= 0 || amount > balance) {
      return false;
    }
    balance -= amount;
    return true;
  }

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    }
  }
}
