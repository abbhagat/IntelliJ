package lld.shoppingcart;

public class PercentageDiscount implements DiscountStrategy {

  private final double percent;

  public PercentageDiscount(double percent) {
    this.percent = percent;
  }

  @Override
  public double applyDiscount(double amount) {
    double discount = amount * percent / 100;
    System.out.println("Discount : " + discount);
    return amount - discount;
  }
}
