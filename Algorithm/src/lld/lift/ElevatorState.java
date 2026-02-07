package lld.lift;

public enum ElevatorState {
  MOVING, STOPPED, IDLE
}

/*
 * STOPPED :- Lift is not moving but it has work to do Doors may be opening / open / closing
 * | STOPPED              | IDLE                    |
 * | -------------------- | ----------------------- |
 * | Has pending requests | No pending requests     |
 * | Doors may be open    | Doors closed            |
 * | Will move again soon | Waiting for new request |

 * IDLE — “Waiting for work” Lift is not moving
 * Doors are usually closed
 * No pending requests assigned (or waiting for next instruction)
 * Why it’s needed
 * IDLE tells the scheduler: “I’m free, assign me a request.”
 * Helps in nearest-lift selection
 *
 * Prevents unnecessary movement
 */