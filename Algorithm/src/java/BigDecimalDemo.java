package java8;

import java.math.BigDecimal;

public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("5");
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.compareTo(BigDecimal.ONE));
        System.out.println(bigDecimal.compareTo(BigDecimal.TEN));
        System.out.println(bigDecimal.compareTo(BigDecimal.valueOf(5)));
    }
}
