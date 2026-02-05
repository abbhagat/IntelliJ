package lld.lift;

import java.util.List;

public class ElevatorScheduler {

  public Elevator selectElevator(List<Elevator> elevators, Request request) {
    Elevator bestElevator = null;
    int minDistance = Integer.MAX_VALUE;
    for (Elevator elevator : elevators) {
      if (elevator.state == ElevatorState.IDLE) {
        int distance = Math.abs(elevator.currentFloor - request.floor);
        if (distance < minDistance) {
          minDistance = distance;
          bestElevator = elevator;
        }
      }
    }
    return bestElevator;
  }
}
