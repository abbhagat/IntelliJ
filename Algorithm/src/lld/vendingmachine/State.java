package lld.vendingmachine;

public interface State {
  void selectProduct(Product product);
  void insertCoin(Coin coin);
  void dispenseProduct();
  void cancelProduct();
}
