package lld.rapido;

public class Driver {

  private final String id;
  private final Vehicle vehicle;

  private DriverStatus status;
  private Location location;

  public Driver(String id, Vehicle vehicle, Location location) {
    this.id = id;
    this.vehicle = vehicle;
    this.location = location;
    this.status = DriverStatus.OFFLINE;
  }

  public synchronized boolean assignRide() {
    if (status != DriverStatus.AVAILABLE) {
      return false;
    }

    status = DriverStatus.BUSY;
    return true;
  }

  public synchronized void makeAvailable() {
    status = DriverStatus.AVAILABLE;
  }

  public synchronized void goOffline() {
    status = DriverStatus.OFFLINE;
  }

  public synchronized DriverStatus getStatus() {
    return status;
  }

  public Location getLocation() {
    return location;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public String getId() {
    return id;
  }
}
