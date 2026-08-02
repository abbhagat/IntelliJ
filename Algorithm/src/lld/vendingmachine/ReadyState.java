package lld.vendingmachine;

public class ReadyState implements State {

  private final VendingMachine vendingMachine;

  public ReadyState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin(Coin coin) {
    vendingMachine.addBalance(coin.getValue());
    if (vendingMachine.hasEnoughMoney()) {
      vendingMachine.setState(new DispenseState(vendingMachine));
    }
  }

  @Override
  public void selectProduct(Product product) {
  }

  @Override
  public void dispense() {
  }

  @Override
  public void cancel() {
    vendingMachine.refund();
    vendingMachine.setState(new IdleState(vendingMachine));
  }
}
