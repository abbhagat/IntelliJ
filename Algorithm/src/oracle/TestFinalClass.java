package oracle;

import java.util.Date;

record FinalClass(String key, int value, Date date) {

  @Override
  public Date date() {
    return (Date) this.date.clone();
  }

}

public class TestFinalClass {

  public static void main(String[] args) {
    FinalClass finalObj = new FinalClass("A", 65, new Date());
    System.out.println(finalObj.hashCode());
    finalObj.date().setTime(10000);
    System.out.println(finalObj.hashCode());
  }
}
