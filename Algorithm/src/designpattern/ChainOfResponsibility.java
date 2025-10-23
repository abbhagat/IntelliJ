package designpattern;

import lombok.Setter;

// Chain of responsibility pattern creates a chain of receiver objects for a request.

@Setter
abstract class AbstractLogger {

  private AbstractLogger nextLogger;

  public void logMessage(String message) {
    write(message);
    if (nextLogger != null) {
      nextLogger.logMessage(message);
    }
  }

  abstract public void write(String message);
}

class ConsoleLogger extends AbstractLogger {
  public void write(String message) {
    System.out.println("Console Logger");
  }
}

class ErrorLogger extends AbstractLogger {
  public void write(String message) {
    System.out.println("Error Logger");
  }
}

class DebugLogger extends AbstractLogger {
  public void write(String message) {
    System.out.println("Debug Logger");
  }
}

public class ChainOfResponsibility {

  private static AbstractLogger getChainOfLoggers() {
    AbstractLogger consoleLogger = new ConsoleLogger();
    AbstractLogger debugLogger = new DebugLogger();
    AbstractLogger errorLogger = new ErrorLogger();
    errorLogger.setNextLogger(debugLogger);
    debugLogger.setNextLogger(consoleLogger);
    return errorLogger;
  }

  public static void main(String[] args) {
    AbstractLogger loggerChain = getChainOfLoggers();
    loggerChain.logMessage("This is an information.");
  }
}
