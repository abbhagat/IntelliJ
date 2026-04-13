package lld.lift;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorSystem {

  private final List<Elevator> elevators;
  private final ElevatorScheduler scheduler;
  private final ExecutorService executorService;

  public ElevatorSystem(int numberOfElevators) {
    scheduler       = new ElevatorScheduler();
    executorService = Executors.newFixedThreadPool(10);
    elevators       = new ArrayList<>();
    for (int i = 1; i <= numberOfElevators; i++) {
      elevators.add(new Elevator(i, executorService));
    }
  }

  public void shutdown() {
    executorService.shutdown();
  }

  public void handleRequest(Request request) {
    Elevator elevator = scheduler.selectElevator(elevators, request);
    if (elevator != null) {
      elevator.addRequest(request.floor());
    }
  }

  public static void main(String[] args) {
    ElevatorSystem elevatorSystem = new ElevatorSystem(5);
    elevatorSystem.handleRequest(new Request(2, Direction.UP));
    elevatorSystem.handleRequest(new Request(1, Direction.DOWN));
    elevatorSystem.handleRequest(new Request(3, Direction.UP));
    elevatorSystem.shutdown();
  }
}
