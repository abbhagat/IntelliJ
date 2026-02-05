package lld;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

enum Direction {
  UP, DOWN, IDLE
}

enum ElevatorState {
  MOVING, STOPPED, IDLE
}

class Request {
  int floor;
  Direction direction;

  public Request(int floor, Direction direction) {
    this.floor = floor;
    this.direction = direction;
  }
}

class Elevator {

  int id;
  int currentFloor;
  Direction direction;
  ElevatorState state;

  PriorityQueue<Integer> upQueue = new PriorityQueue<>();
  PriorityQueue<Integer> downQueue =
      new PriorityQueue<>((a, b) -> b - a);

  public Elevator(int id) {
    this.id = id;
    this.currentFloor = 0;
    this.direction = Direction.IDLE;
    this.state = ElevatorState.IDLE;
  }

  public void addRequest(int floor) {
    if (floor > currentFloor) {
      upQueue.offer(floor);
    } else {
      downQueue.offer(floor);
    }
    updateState();
  }

  private void updateState() {
    if (!upQueue.isEmpty()) {
      direction = Direction.UP;
      state = ElevatorState.MOVING;
    } else if (!downQueue.isEmpty()) {
      direction = Direction.DOWN;
      state = ElevatorState.MOVING;
    } else {
      direction = Direction.IDLE;
      state = ElevatorState.IDLE;
    }
  }

  public void move() {
    if (direction == Direction.UP) {
      currentFloor = upQueue.poll();
    } else if (direction == Direction.DOWN) {
      currentFloor = downQueue.poll();
    }
    state = ElevatorState.STOPPED;
    updateState();
  }
}

class ElevatorScheduler {

  public Elevator selectElevator(
      java.util.List<Elevator> elevators,
      Request request
  ) {
    Elevator bestElevator = null;
    int minDistance = Integer.MAX_VALUE;

    for (Elevator elevator : elevators) {
      if (elevator.state == ElevatorState.IDLE) {
        int distance =
            Math.abs(elevator.currentFloor - request.floor);
        if (distance < minDistance) {
          minDistance = distance;
          bestElevator = elevator;
        }
      }
    }
    return bestElevator;
  }
}

class ElevatorSystem {

  List<Elevator> elevators;
  ElevatorScheduler scheduler;

  public ElevatorSystem(int numberOfElevators) {
    elevators = new ArrayList<>();
    scheduler = new ElevatorScheduler();

    for (int i = 0; i < numberOfElevators; i++) {
      elevators.add(new Elevator(i));
    }
  }

  public void handleRequest(Request request) {
    Elevator elevator =
        scheduler.selectElevator(elevators, request);

    if (elevator != null) {
      elevator.addRequest(request.floor);
    }
  }
}

public class LiftSystem {

  public static void main(String[] args) {

  }

}
