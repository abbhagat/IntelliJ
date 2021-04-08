package parking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Parking {

    private String vehicleNumber;
    private String parkingNumber;
    private boolean isAvailable;

    public Parking(String vehicleNumber, String parkingNumber, boolean isAvailable) {
        this.parkingNumber = parkingNumber;
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = isAvailable;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(String parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvaiable(boolean avaiable) {
        isAvailable = avaiable;
    }

    @Override
    public String toString() {
        return this.getParkingNumber() + " " + this.getVehicleNumber() + " " + this.isAvailable();
    }
}

public class ParkingSpot {

    private Map<String, Map<String, List<Parking>>> parkingMap;
    private Map<String, Boolean> availableParkingLevel;
    private List<String> basement = Arrays.asList("B1", "B2", "B3");
    private List<String> spots = Arrays.asList("S1", "S2", "S3");

    public void initializeMap() {
        availableParkingLevel = new ConcurrentHashMap<>();
        parkingMap = new ConcurrentHashMap<>();
        basement.forEach(level -> {
            Map<String, List<Parking>> spotMap = new ConcurrentHashMap<>();
            spots.forEach(spot -> {
                spotMap.put(spot, Arrays.asList(new Parking(null, "P1", true), new Parking(null, "P2", true), new Parking(null, "P3", true)));
            });
            parkingMap.put(level, spotMap);
            availableParkingLevel.put(level, true);
        });
    }

    public String assignParking(String vehicleNum) {
        String parkingDetails = "";
        for (String basementLevel : basement) {
            if (availableParkingLevel.get(basementLevel)) {
                Map<String, List<Parking>> spotMap = parkingMap.get(basementLevel);
                Set<Map.Entry<String, List<Parking>>> set = spotMap.entrySet();
                for (Map.Entry<String, List<Parking>> map : set) {
                    for (Parking parking : map.getValue()) {
                        if (parking.isAvailable()) {
                            parking.setAvaiable(false);
                            parking.setVehicleNumber(vehicleNum);
                            return basementLevel + " " + map.getKey() + " " + parking.getParkingNumber();
                        }
                    }
                }
            }
        }
        return parkingDetails;
    }

    public static void main(String[] args) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.initializeMap();
        parkingSpot.parkingMap.forEach((k, v) -> System.out.println(k + "\t" + v));

        List<String> vehicles = Arrays.asList("KA01MS1210", "TS07FC8413", "JH01MS1076", "KA01MS1210", "TS07FC8413", "JH01MS1076", "KA01MS1210", "TS07FC8413", "JH01MS1076", "KA01MS1210", "TS07FC8413", "JH01MS1076");
        vehicles.forEach(vehicleNum -> {
            String parkingDetails = parkingSpot.assignParking(vehicleNum);
            System.out.println(vehicleNum + " -> " + parkingDetails);
        });
        parkingSpot.parkingMap.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}
