package lld.lift;

import java.util.ArrayList;
import java.util.List;

class ElevatorSystem {

  private final List<Elevator> elevators;
  private final SelectElevator selectElevator;

  public ElevatorSystem(int numberOfElevators) {
    selectElevator = new SelectElevator();
    elevators       = new ArrayList<>();
    for (int i = 1; i <= numberOfElevators; i++) {
      elevators.add(new Elevator(i));
    }
  }

  public void handleRequest(Request request) {
    Elevator elevator = selectElevator.bestElevator(elevators, request);
    if (elevator != null) {
      elevator.addRequest(request);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ElevatorSystem elevatorSystem = new ElevatorSystem(5);
    elevatorSystem.handleRequest(new Request(2, Direction.UP));
    elevatorSystem.handleRequest(new Request(1, Direction.DOWN));
    elevatorSystem.handleRequest(new Request(3, Direction.UP));
  }
}
