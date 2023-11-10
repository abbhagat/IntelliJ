# Ping Identity Take Home Coding Exercise

Imagine that you are part of a software development team that is building an
enterprise server that validates incoming security tokens. Each member of your
team has to implement a different part of the token validation process. One
important part of the process is ensuring that every token is received only once
-- this is known as "replay prevention". Your job will be to implement an
interface that examines each token as it enters the system and verify it has not
been seen previously.

Implement the interface by filling out the stub implementation in the
TokenReplayPreventionImpl class.

## Key requirements:

* The replay prevention implementation must be thread safe. This class will be instantiated as a singleton by dependency injection. Thus,
  multiple threads may be invoking methods on an instance of the object at any
  given time.

* While it is acceptable to track the tokens in memory (don't worry about
  maintaining state between server restarts), you must ensure that the
  process does not run out of memory under reasonable load. Once a token has
  expired, you do not need to continue tracking replays of it.

## Givens:

* All tokens passed to the interface are guaranteed to be current and
  properly formed. Validation of their expiration, form, etc. is done prior to the
  interface invocation. Your goal is simply to ensure that a token is not being
  replayed.

* Comparison of two tokens may be done using the token ID.

## Implementation Notes

You should only need to modify the TokenReplayPreventionImpl class to complete
the exercise. You may add additional or more robust unit tests to the
ReplayPreventionSimpleTest class -- this is considered to be extra credit.

ReplayPreventionSimpleTest contains a very basic test that will fail against the stub
implementation of the TokenReplayPreventionImpl class. At the very minimum, this
test should pass when you have completed the exercise. However, the test is only a
starting point. Passing the included unit test does not guarantee your code
satisfies the requirements specified above.

The use of third-party libraries is allowed, but not required. Please do not
share this exercise publicly.

Please return your implementation (included with the whole package) prior
to the provided deadline.

## Part 2
Let's say the enterprise server for which your replay prevention service has been implemented is being deployed to the cloud, and it now requires a token replay prevention microservice implementation.


At a high level, please provide a diagram of what this might look like. Consider high throughput and resiliency in the face of any number of your microservice instances being terminated at any time.
