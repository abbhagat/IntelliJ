package lld.atm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ATMCard {

  @Getter
  private final String cardNumber;
  private final int pin;

  public boolean validatePin(int enteredPin) {
    return pin == enteredPin;
  }
}
