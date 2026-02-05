package lld.lift;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {

  private final List<Elevator> elevators;
  private final ElevatorScheduler scheduler;

  public ElevatorSystem(int numberOfElevators) {
    elevators = new ArrayList<>();
    scheduler = new ElevatorScheduler();
    for (int i = 0; i < numberOfElevators; i++) {
      elevators.add(new Elevator(i));
    }
  }

  public void handleRequest(Request request) {
    Elevator elevator = scheduler.selectElevator(elevators, request);
    if (elevator != null) {
      elevator.addRequest(request.floor);
    }
  }

  public static void main(String[] args) {

  }
}
