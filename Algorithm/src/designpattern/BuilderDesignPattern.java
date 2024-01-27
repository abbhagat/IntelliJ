package designpattern;

import lombok.Getter;

/**
 * In builder design pattern we build a complex object using simple object and uses step-by-step approach.
 * First of all you need to create a static nested class and then copy all the arguments from the outer class to the Builder class.
 * We should follow the naming convention and if the class name is Computer then builder class should be named as ComputerBuilder.
 * Java Builder class should have a public constructor with all the required attributes as parameters.
 * Java Builder class should have methods to set the optional parameters, and it should return the same Builder object after setting the optional attribute.
 * The final step is to provide a build() method in the builder class that will return the Object needed by client program.
 * For this we need to have a private constructor in the Class with Builder class as argument.
 */

@Getter
class Computer {

    private final String HDD;
    private final String RAM;
    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;

    private Computer(Builder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled    = builder.isBluetoothEnabled;
    }

    public String toString() {
        return this.getHDD() + " " + this.getRAM() + " " + this.isGraphicsCardEnabled() + " " + this.isBluetoothEnabled();
    }

    public static class Builder {
        private String HDD;
        private String RAM;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public Builder setHDD(String HDD) {
            this.HDD = HDD;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderDesignPattern {

    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                                        .setHDD("500 GB")
                                        .setRAM("2 GB")
                                        .setBluetoothEnabled(true)
                                        .setGraphicsCardEnabled(true)
                                        .build();
        System.out.println(computer);
    }
}
