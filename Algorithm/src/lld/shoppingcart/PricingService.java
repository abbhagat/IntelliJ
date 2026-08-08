package lld.shoppingcart;

public class PricingService {

  private static final double TAX_RATE = 0.1; // 10%

  public double calculateTotal(ShoppingCart shoppingCart, DiscountStrategy discountStrategy) {
    double subtotal = shoppingCart.getCartItemMap()
                                  .values()
                                  .stream()
                                  .mapToDouble(CartItem::getTotalPrice)
                                  .sum();
    double cost = discountStrategy.applyDiscount(subtotal);
    double tax  = cost * TAX_RATE;
    return cost + tax;
  }
}
