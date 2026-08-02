package lld.vendingmachine;

public class VendingMachineImpl {

  public static void main(String[] args) {

    // Create products
    Product coke = new Product("1", "Coke", 40);
    Product pepsi = new Product("2", "Pepsi", 35);
    Product chips = new Product("3", "Chips", 25);

    // Create inventory
    Inventory inventory = new Inventory();
    inventory.addProduct(coke, 5);
    inventory.addProduct(pepsi, 3);
    inventory.addProduct(chips, 10);

    // Create vending machine
    VendingMachine machine = new VendingMachine();
    machine.setInventory(inventory);
    // Buy Coke
    System.out.println("Buying Coke...");
    machine.selectProduct(coke);
    machine.insertCoin(Coin.TEN);
    machine.insertCoin(Coin.TEN);
    machine.insertCoin(Coin.TEN);
    machine.insertCoin(Coin.TEN);
    machine.dispense();
    System.out.println();
    // Buy Chips
    System.out.println("Buying Chips...");
    machine.selectProduct(chips);
    machine.insertCoin(Coin.TEN);
    machine.insertCoin(Coin.TEN);
    machine.insertCoin(Coin.FIVE);
    machine.dispense();
    System.out.println();
    // Cancel transaction
    System.out.println("Cancel Transaction...");
    machine.selectProduct(pepsi);
    machine.insertCoin(Coin.TEN);
    machine.insertCoin(Coin.TEN);
    machine.cancel();
  }
}
