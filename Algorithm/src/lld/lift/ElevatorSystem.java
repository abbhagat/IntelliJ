package lld.lift;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {

  private final List<Elevator> elevators;
  private final ElevatorScheduler scheduler;

  public ElevatorSystem(int numberOfElevators) {
    elevators = new ArrayList<>();
    scheduler = new ElevatorScheduler();
    for (int i = 1; i <= numberOfElevators; i++) {
      elevators.add(new Elevator(i));
    }
  }

  public void handleRequest(Request request) {
    Elevator elevator = scheduler.selectElevator(elevators, request);
    if (elevator != null) {
      elevator.addRequest(request.floor());
    }
  }

  public static void main(String[] args) {
    ElevatorSystem elevatorSystem = new ElevatorSystem(4);
    elevatorSystem.handleRequest(new Request(2, Direction.UP));
    elevatorSystem.handleRequest(new Request(1, Direction.DOWN));
    elevatorSystem.handleRequest(new Request(3, Direction.UP));
  }
}
