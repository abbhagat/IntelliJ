package lld.lift;

import java.util.List;

public class ElevatorScheduler {

  public Elevator selectElevator(List<Elevator> elevators, Request request) {
    Elevator bestElevator = null;
    int min = Integer.MAX_VALUE;
    for (Elevator elevator : elevators) {
      if (elevator.getState() == ElevatorState.IDLE) {
        int dist = Math.abs(elevator.getCurrentFloor() - request.floor());
        if (min > dist) {
          min = dist;
          bestElevator = elevator;
        }
      }
    }
    return bestElevator;
  }
}
