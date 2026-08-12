package lld.shoppingcart;

import java.util.List;

public class CouponDiscount implements DiscountStrategy {

  private final List<Integer> coupons;

  public CouponDiscount(List<Integer> coupons) {
    this.coupons = coupons;
  }

  @Override
  public double applyDiscount(double amount) {
    double discount = coupons.stream().mapToInt(Integer::intValue).sum();
    System.out.println("Discount : " + discount);
    return Math.max(0, amount - discount);
  }
}
