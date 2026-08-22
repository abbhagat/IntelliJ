package lld.atm;

public record Card(String cardNumber, int pin) {

  public boolean validatePin(int enteredPin) {
    return pin == enteredPin;
  }

}
