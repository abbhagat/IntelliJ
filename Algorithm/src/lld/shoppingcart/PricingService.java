package lld.shoppingcart;

public class PricingService {

  private static final double TAX_RATE = 0.1; // 10%

  public double calculateTotal(ShoppingCart cart, DiscountStrategy discount) {
    double subtotal = cart.getItemMap()
        .values()
        .stream()
        .mapToDouble(CartItem::getTotalPrice)
        .sum();
    double discounted = discount.applyDiscount(subtotal);
    return discounted + (discounted * TAX_RATE);
  }
}
