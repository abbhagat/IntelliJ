package lld.lift;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;

@Getter
@Setter
public class Elevator {

  private int id;
  private int currentFloor;
  private Direction direction;
  private ElevatorState state;

  private final BlockingQueue<Integer> upQueue   = new PriorityBlockingQueue<>();  // serve the nearest higher floors first
  private final BlockingQueue<Integer> downQueue = new PriorityBlockingQueue<>(10, (a, b) -> b - a); // serve the nearest lower floors first

  public Elevator(int id, ExecutorService executorService) {
    this.id = id;
    this.currentFloor = 0;
    this.direction = Direction.IDLE;
    this.state = ElevatorState.IDLE;
    executorService.submit(this::processRequests);
  }

  private void processRequests() {
    try {
      while (!Thread.currentThread().isInterrupted()) {
        int nextFloor;
        if (!upQueue.isEmpty()) {
          direction = Direction.UP;
          state = ElevatorState.MOVING;
          nextFloor = upQueue.take();  // blocks if empty
        } else if (!downQueue.isEmpty()) {
          direction = Direction.DOWN;
          state = ElevatorState.MOVING;
          nextFloor = downQueue.take(); // blocks if empty
        } else {
          state = ElevatorState.IDLE;
          direction = Direction.IDLE;
          // block until ANY request arrives
          nextFloor = upQueue.take();
          direction = Direction.UP;
          state = ElevatorState.MOVING;
        }
        moveTo(nextFloor);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public synchronized void addRequest(int floor) {
    var x = floor > currentFloor ? upQueue.offer(floor) : downQueue.offer(floor);
    System.out.println("Request added: " + floor);
  }

  public void moveTo(int targetFloor) throws InterruptedException {
    System.out.println("Elevator " + id + " moving from " + currentFloor + " to " + targetFloor);
    Thread.sleep(Math.abs(targetFloor - currentFloor) * 100L);
    currentFloor = targetFloor;
    state = ElevatorState.STOPPED;
    System.out.println("Elevator " + id + " stopped at " + currentFloor);
  }
}
