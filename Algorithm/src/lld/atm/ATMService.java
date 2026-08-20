package lld.atm;

import java.util.HashMap;
import java.util.Map;

public class ATMService {

  private final Map<String, Account> accounts = new HashMap<>();

  public void addAccount(String cardNumber, Account account) {
    accounts.put(cardNumber, account);
  }

  public Account getAccount(String cardNumber) {
    return accounts.get(cardNumber);
  }
}
