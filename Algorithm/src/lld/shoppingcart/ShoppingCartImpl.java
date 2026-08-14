package lld.shoppingcart;

import static lld.shoppingcart.PricingService.calculateTotal;

public class ShoppingCartImpl {

  public static void main(String[] args) {

    Product iPhone = new Product("P01", "Iphone", 50000);
    Product camera = new Product("P02", "Camera", 10000);
    Product milk   = new Product("P03", "Milk",   5000);

    ShoppingShoppingCart shoppingCart = new ShoppingShoppingCart();
    shoppingCart.addItem(iPhone, 1);
    shoppingCart.addItem(camera, 2);
    shoppingCart.updateItem(iPhone.id(), 2);
    shoppingCart.removeItem(milk.id());

    System.out.println("Bill Details");
    System.out.print(shoppingCart);
    double billAmount = calculateTotal(shoppingCart, new PercentageDiscount(10));
    System.out.println("Total Bill : " + billAmount);
  }
}
