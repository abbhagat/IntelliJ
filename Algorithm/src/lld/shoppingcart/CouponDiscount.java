package lld.shoppingcart;

public class CouponDiscount implements DiscountStrategy {

  private final double flatAmount;

  public CouponDiscount(double flatAmount) {
    this.flatAmount = flatAmount;
  }

  @Override
  public double applyDiscount(double amount) {
    return Math.max(0, amount - flatAmount);
  }
}
