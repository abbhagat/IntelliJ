package designing.parking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Parking {

    private String vehicleNumber;
    private String parkingNumber;
    private boolean isAvailable;
    private String vehicleType;

    public Parking(String vehicleNumber, String parkingNumber, boolean isAvailable, String vehicleType) {
        this.parkingNumber = parkingNumber;
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = isAvailable;
        this.vehicleType = vehicleType;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return this.getParkingNumber() + " " + this.getVehicleNumber() + " " + this.isAvailable() + " " + this.getVehicleType();
    }
}

public class ParkingSpot {

    private Map<String, Map<String, List<Parking>>> parkingMap;
    private Map<String, Boolean> availableParkingLevel;
    private List<String> basement = Arrays.asList("B1", "B2", "B3");
    private List<String> parkingSpot = Arrays.asList("P1", "P2", "P3");

    public void initializeMap() {
        availableParkingLevel = new ConcurrentHashMap<>();
        parkingMap = new ConcurrentHashMap<>();
        basement.forEach(level -> {
            Map<String, List<Parking>> parkingSpotMap = new ConcurrentHashMap<>();
            parkingSpot.forEach(parking -> parkingSpotMap.put(parking, Arrays.asList(new Parking(null, "P1", true, "Car"), new Parking(null, "P2", true, "Bike"), new Parking(null, "P3", true, "Bus"))));
            parkingMap.put(level, parkingSpotMap);
            availableParkingLevel.put(level, true);
        });
    }

    public String assignParking(String vehicleNum, String vechileType) {
        String parkingDetails = "";
        for (String basementLevel : basement) {
            if (availableParkingLevel.get(basementLevel)) {
                Map<String, List<Parking>> spotMap = parkingMap.get(basementLevel);
                Set<Map.Entry<String, List<Parking>>> set = spotMap.entrySet();
                for (Map.Entry<String, List<Parking>> map : set) {
                    for (Parking parking : map.getValue()) {
                        if (parking.isAvailable() && parking.getVehicleType().equals(vechileType)) {
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
        String parkingDetails = parkingSpot.assignParking("KA01MS1210", "Car");
        System.out.println("KA01MS1210" + " -> " + parkingDetails);
        parkingSpot.parkingMap.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}
