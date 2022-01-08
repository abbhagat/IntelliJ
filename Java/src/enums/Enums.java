package enums;

public class Enums {

    protected enum Fruits {

        Apple(100),
        Mango(200),
        Guava(300),
        Orange() {
            public int getPrice() {
                return this.price;
            }
        };

        int price;

        Fruits(int price) {
            this.price = price;
        }

        Fruits() {
            this.price = 400;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {

        Fruits f = Fruits.Apple;
        System.out.println(f.getPrice());

        System.out.println(f.Apple.equals(f.Orange));
        System.out.println(f.Apple.ordinal());
        for (Fruits fruit : Fruits.values()) {
            System.out.println(fruit + "\t" + fruit.getPrice());
        }
    }
}
