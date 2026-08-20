package lld.atm;

import java.util.HashMap;
import java.util.Map;

public class BankService {

  private final Map<String, Account> map = new HashMap<>();

  public void addAccount(String cardNumber, Account account) {
    map.put(cardNumber, account);
  }

  public Account getAccount(String cardNumber) {
    return map.get(cardNumber);
  }

}
