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
    this.state     = ElevatorState.IDLE;
    executorService.submit(this::processRequests);
  }

  public synchronized void addRequest(int floor) {
    var success = floor > currentFloor ? upQueue.add(floor) : downQueue.add(floor);
    System.out.println("Request added for floor : " + floor + (success ? " success" : "fail"));
  }

  private void processRequests() {  // Runs in separate thread
    while (!Thread.currentThread().isInterrupted()) {
      try {
        int destFloor;
        if (!upQueue.isEmpty()) {
          direction = Direction.UP;
          state     = ElevatorState.MOVING;
          destFloor = upQueue.take();        // blocks if Queue empty So you don’t need manual synchronization logic.
        } else if (!downQueue.isEmpty()) {
          direction = Direction.DOWN;
          state     = ElevatorState.MOVING;
          destFloor = downQueue.take();    // blocks if empty So you don’t need manual synchronization logic.
        } else {
          direction = Direction.IDLE;
          state     = ElevatorState.IDLE;
          destFloor = upQueue.take();    // block until ANY request arrives
          direction = Direction.UP;
          state     = ElevatorState.MOVING;
        }
        moveToDestFloor(destFloor);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void moveToDestFloor(int destFloor) throws InterruptedException {
    System.out.println("Elevator " + id + " moving from " + currentFloor + " to " + destFloor);
    // Thread.sleep is used to simulate the time taken by the elevator to move between floors.
    Thread.sleep(Math.abs(destFloor - currentFloor) * 100L);
    currentFloor = destFloor;
    state = ElevatorState.STOPPED;
    System.out.println("Elevator " + id + " stopped at " + currentFloor);
  }
}
