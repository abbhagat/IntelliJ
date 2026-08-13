package lld.vendingmachine;

public class VendingMachineImpl {

  public static void main(String[] args) {

    // Create products
    Product coke  = new Product("1", "Coke",  40);
    Product pepsi = new Product("2", "Pepsi", 35);
    Product chips = new Product("3", "Chips", 25);

    // Create inventory
    Inventory inventory = new Inventory();
    inventory.addProduct(coke,  5);
    inventory.addProduct(pepsi, 3);
    inventory.addProduct(chips, 10);

    // Create vending vendingMachine
    VendingMachine vendingMachine = new VendingMachine();
    vendingMachine.setInventory(inventory);
    // Buy Coke
    System.out.println("Buying Coke...");
    vendingMachine.selectProduct(coke);
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.dispense();
    System.out.println();
    // Buy Chips
    System.out.println("Buying Chips...");
    vendingMachine.selectProduct(chips);
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.insertCoin(Coin.FIVE);
    vendingMachine.dispense();
    System.out.println();
    // Cancel transaction
    System.out.println("Cancel Transaction...");
    vendingMachine.selectProduct(pepsi);
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.cancel();
  }
}
