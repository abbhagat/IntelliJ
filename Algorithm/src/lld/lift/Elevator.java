package lld.lift;

import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;

@Getter
@Setter
public class Elevator {

  private int id;
  private int currentFloor;
  private Direction direction;
  private ElevatorState state;

  PriorityQueue<Integer> upQueue   = new PriorityQueue<>();
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
