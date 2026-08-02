package lld.vendingmachine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachine {

  private Inventory inventory;

  private State currentState;

  private Product selectedProduct;

  private int balance;

  public VendingMachine() {
    currentState = new IdleState(this);
  }

  public void selectProduct(Product product) {
    currentState.selectProduct(product);
  }

  public void insertCoin(Coin coin) {
    currentState.insertCoin(coin);
  }

  public void dispense() {
    currentState.dispense();
  }

  public void cancel() {
    currentState.cancel();
  }

  // helper methods

  public void addBalance(int value) {
    balance += value;
  }

  public boolean hasEnoughMoney() {
    return balance >= selectedProduct.getPrice();
  }

  public void returnChange() {
    int change = balance - selectedProduct.getPrice();
    System.out.println("Returning " + change);
  }

  public void dispenseProduct() {
    System.out.println(selectedProduct.getName());
  }

  public void refund() {
    System.out.println(balance);
  }

  public void reset() {
    balance = 0;
    selectedProduct = null;
  }

  public void setState(State state) {
    currentState = state;
  }
}
