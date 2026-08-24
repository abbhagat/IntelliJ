package lld.rapido;

public record Location(double latitude, double longitude) {

  public double distanceTo(Location destination) {
    double latDiff = latitude  - destination.latitude;
    double lonDiff = longitude - destination.longitude;
    return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
  }
}
