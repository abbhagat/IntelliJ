package lld.shoppingcart;

import java.util.List;

public class CouponDiscount implements DiscountStrategy {

  private final List<Integer> coupons;

  public CouponDiscount(List<Integer> coupons) {
    this.coupons = coupons;
  }

  @Override
  public double applyDiscount(double amount) {
    return Math.max(0, amount - coupons.stream().mapToInt(Integer::intValue).sum());
  }
}
