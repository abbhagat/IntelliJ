package lld.atm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Card {

  @Getter
  private final String cardNumber;
  private final int pin;

  public boolean validatePin(int enteredPin) {
    return pin == enteredPin;
  }
}
