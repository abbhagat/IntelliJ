package lld.shoppingcart;

public class PricingService {

  private static final double GST_RATE = 0.1; // 10%

  public static double calculateTotal(ShoppingShoppingCart shoppingCart, DiscountStrategy discountStrategy) {
    double subtotal = shoppingCart.getCartItemMap()
                                  .values()
                                  .stream()
                                  .mapToDouble(CartItem::getTotalPrice)
                                  .sum();
    System.out.println("Total Cost : " + subtotal);
    double cost = discountStrategy.applyDiscount(subtotal);
    double gst  = cost * GST_RATE;
    return cost + gst;
  }
}
