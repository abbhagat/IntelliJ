package lld.lift;

import java.util.PriorityQueue;

public class Elevator {

  int id;
  int currentFloor;
  Direction direction;
  ElevatorState state;

  PriorityQueue<Integer> upQueue = new PriorityQueue<>();
  PriorityQueue<Integer> downQueue = new PriorityQueue<>((a, b) -> b - a);

  public Elevator(int id) {
    this.id = id;
    this.currentFloor = 0;
    this.direction = Direction.IDLE;
    this.state = ElevatorState.IDLE;
  }

  public void addRequest(int floor) {
    var x = floor > currentFloor ? upQueue.offer(floor) : downQueue.offer(floor);
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
