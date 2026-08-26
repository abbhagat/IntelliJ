package lld.vendingmachine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachine {

  private Inventory inventory;
  private State     state;
  private Product   product;
  private int       balance;

  public VendingMachine() {
    state = new IdleState(this);
  }

  public void selectProduct(Product product) {
    state.selectProduct(product);
  }

  public void insertCoin(Coin coin) {
    state.insertCoin(coin);
  }

  public void dispense() {
    state.dispenseProduct();
  }

  public void cancel() {
    state.cancelProduct();
  }

  public void addBalance(int value) {
    balance += value;
  }

  public boolean hasEnoughMoney() {
    return balance >= product.price();
  }

  public void returnChange() {
    int change = balance - product.price();
    System.out.println("Returning " + change);
  }

  public void dispenseProduct() {
    System.out.println(product.name());
  }

  public void refund() {
    System.out.println(balance);
  }

  public void reset() {
    balance = 0;
    product = null;
  }

  public void setState(State state) {
    this.state = state;
  }
}
