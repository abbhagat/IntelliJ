package lld.vendingmachine;

public class DispenseState implements State {

  private final VendingMachine vendingMachine;

  public DispenseState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void dispenseProduct() {
    vendingMachine.dispenseProduct();
    vendingMachine.returnChange();
    vendingMachine.reset();
    vendingMachine.setState(new IdleState(vendingMachine));
  }

  @Override
  public void insertCoin(Coin coin) {}

  @Override
  public void selectProduct(Product product) {}

  @Override
  public void cancelProduct() {}
}
