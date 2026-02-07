package lld.shoppingcart;

public class PercentageDiscount implements DiscountStrategy {

  private final double percent;

  public PercentageDiscount(double percent) {
    this.percent = percent;
  }

  @Override
  public double applyDiscount(double amount) {
    return amount - (amount * percent / 100);
  }
}
