package lld.vendingmachine;

public class IdleState implements State {

  private final VendingMachine machine;

  public IdleState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void selectProduct(Product product) {
    machine.setSelectedProduct(product);
    machine.setState(new ReadyState(machine));
  }

  @Override
  public void insertCoin(Coin coin) {
    throw new IllegalStateException("Select product first");
  }

  @Override
  public void dispense() {
  }

  @Override
  public void cancel() {
  }
}
