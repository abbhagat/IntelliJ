package designpattern;

import java.util.Optional;

/**
 * In builder design pattern we build a complex object using simple object and uses step-by-step approach.
 * <p>
 * First of all you need to create a static nested class and then copy all the arguments from the outer class to the Builder class.
 * We should follow the naming convention and if the class name is Computer then builder class should be named as ComputerBuilder.
 * Java Builder class should have a public constructor with all the required attributes as parameters.
 * Java Builder class should have methods to set the optional parameters, and it should return the same Builder object after setting the optional attribute.
 * The final step is to provide a build() method in the builder class that will return the Object needed by client program.
 * For this we need to have a private constructor in the Class with Builder class as argument.
 */

class Computer {
    private final String HDD;
    private final String RAM;
    private final Optional<Boolean> isGraphicsCardEnabled;
    private final Optional<Boolean> isBluetoothEnabled;

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public Optional<Boolean> isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public Optional<Boolean> isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled    = builder.isBluetoothEnabled;
    }

    public static class ComputerBuilder {
        private final String HDD;
        private final String RAM;
        private Optional<Boolean> isGraphicsCardEnabled;
        private Optional<Boolean> isBluetoothEnabled;

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder setGraphicsCardEnabled(Optional<Boolean> isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(Optional<Boolean> isBluetoothEnabled) {
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
        Computer computer = new Computer.ComputerBuilder("500GB", "2GB")
                .setBluetoothEnabled(Optional.of(true))
                .setGraphicsCardEnabled(Optional.of(true)).build();
        System.out.println(computer.getHDD() + " " + computer.getRAM() + " " + computer.isGraphicsCardEnabled().get() + " " + computer.isBluetoothEnabled().get());
    }
}
