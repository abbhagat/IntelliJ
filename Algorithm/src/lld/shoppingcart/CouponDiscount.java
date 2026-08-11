package lld.shoppingcart;

public class CouponDiscount implements DiscountStrategy {

  @Override
  public double applyDiscount(double amount) {
    return switch ((int) amount) {
      case 50  -> Math.max(0, amount - 50);
      case 100 -> Math.max(0, amount - 100);
      case 200 -> Math.max(0, amount - 200);
      default  -> Math.max(0, amount - 5000);
    };
  }
}
