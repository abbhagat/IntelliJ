package lld.shoppingcart;

public class ShoppingCartImpl {

  public static void main(String[] args) {

    Product iPhone = new Product("P01", "Iphone", 50000);
    Product camera = new Product("P02", "Camera", 10000);

    ShoppingCart shoppingCart = UserCart.get("User1");
    shoppingCart.addItem(iPhone, 1);
    shoppingCart.addItem(camera, 2);
    shoppingCart.updateItem(iPhone.getProductId(), 2);
    UserCart.put(shoppingCart);
    double billAmount = PricingService.calculateTotal(shoppingCart, new PercentageDiscount(10));
    System.out.println("Bill Details");
    System.out.println(UserCart.get("User1"));
    System.out.println(billAmount);
  }
}
