package lld.vendingmachine;

public class IdleState implements State {

  private final VendingMachine vendingMachine;

  public IdleState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(Product product) {
    vendingMachine.setProduct(product);
    vendingMachine.setState(new ReadyState(vendingMachine));
  }

  @Override
  public void insertCoin(Coin coin) {
    throw new IllegalStateException("Select product first");
  }

  @Override
  public void dispenseProduct() {}

  @Override
  public void cancelProduct() {}

}
