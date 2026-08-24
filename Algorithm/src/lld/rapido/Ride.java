package lld.rapido;

public class Ride {

  private final String id;
  private final Rider rider;
  private final Location source;
  private final Location destination;

  private Driver driver;
  private RideStatus status;
  private double fare;

  public Ride(
      String id,
      Rider rider,
      Location source,
      Location destination
  ) {
    this.id = id;
    this.rider = rider;
    this.source = source;
    this.destination = destination;
    this.status = RideStatus.REQUESTED;
  }

  public synchronized void accept(Driver driver) {
    if (status != RideStatus.REQUESTED) {
      throw new IllegalStateException("Ride cannot be accepted");
    }

    this.driver = driver;
    this.status = RideStatus.ACCEPTED;
  }

  public synchronized void start() {
    if (status != RideStatus.ACCEPTED) {
      throw new IllegalStateException("Ride cannot be started");
    }

    status = RideStatus.IN_PROGRESS;
  }

  public synchronized void complete(double fare) {
    if (status != RideStatus.IN_PROGRESS) {
      throw new IllegalStateException("Ride cannot be completed");
    }

    this.fare = fare;
    this.status = RideStatus.COMPLETED;
  }

  public synchronized void cancel() {
    if (status == RideStatus.COMPLETED) {
      throw new IllegalStateException("Completed ride cannot be cancelled");
    }

    status = RideStatus.CANCELLED;
  }

  public RideStatus getStatus() {
    return status;
  }

  public Location getSource() {
    return source;
  }

  public Location getDestination() {
    return destination;
  }

  public Driver getDriver() {
    return driver;
  }

  public double getFare() {
    return fare;
  }
}
