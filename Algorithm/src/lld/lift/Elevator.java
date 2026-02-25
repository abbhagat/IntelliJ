package lld.lift;

import lombok.Getter;
import lombok.Setter;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
public class Elevator {

  private int id;
  private int currentFloor;
  private Direction direction;
  private ElevatorState state;
  private final PriorityQueue<Integer> upQueue = new PriorityQueue<>();                  // serve the nearest higher floors first
  private final PriorityQueue<Integer> downQueue = new PriorityQueue<>((a, b) -> b - a); // serve the nearest lower floors first

  public Elevator(int id, ExecutorService executorService) {
    this.id = id;
    this.currentFloor = 0;
    this.direction = Direction.IDLE;
    this.state = ElevatorState.IDLE;
    executorService.submit(this::processRequests);
  }

  @Override
  public String toString() {
    return "Elevator { " + "id=" + id + ", currentFloor=" + currentFloor + ", direction=" + direction +
        ", state=" + state + ", upQueue=" + upQueue + ", downQueue=" + downQueue + '}';
  }

  private void processRequests() {
    while (!Thread.currentThread().isInterrupted()) {
      move();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public synchronized void addRequest(int floor) {
    var x = floor > currentFloor ? upQueue.add(floor) : downQueue.add(floor);
    updateState();
    System.out.println(this);
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

  public synchronized void move() {
    if (!upQueue.isEmpty() && direction == Direction.UP) {
      currentFloor = upQueue.poll();
    } else if (!downQueue.isEmpty() && direction == Direction.DOWN) {
      currentFloor = downQueue.poll();
    }
    state = ElevatorState.STOPPED;
    updateState();
  }
}
