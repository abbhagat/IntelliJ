package designpattern;

import lombok.Getter;
import lombok.ToString;

// In builder design pattern, we build a complex object using a simple object and use step-by-step approach.

@Getter
@ToString
class Computer {

  private final String HDD;
  private final String RAM;
  private final boolean isBluetoothEnabled;
  private final boolean isGraphicsCardEnabled;

  private Computer(Builder builder) {
    this.HDD = builder.HDD;
    this.RAM = builder.RAM;
    this.isBluetoothEnabled = builder.isBluetoothEnabled;
    this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
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

    Computer build() {
      return new Computer(this);
    }
  }
}

public class BuilderDesignPattern {

  public static void main(String[] args) {
    Computer.Builder builder = new Computer.Builder()
        .setHDD("500 GB")
        .setRAM("2 GB")
        .setBluetoothEnabled(true)
        .setGraphicsCardEnabled(true);
    Computer computer = builder.build();
    System.out.println(computer);
  }
}
