package designpattern;

/**
 * In Template pattern, an abstract class exposes defined way(s)/template(s)
 * to execute its methods. Its subclasses can override the method implementation
 * as per need, but the invocation is to be in the same way as defined by an
 * abstract class.
 */

abstract class Games {

  abstract void init();

  abstract void start();

  abstract void end();

  public final void play() {
    init();
    start();
    end();
  }
}

class Cricket extends Games {

  void init() {
    System.out.println("Cricket Game Initialized! Start playing.");
  }

  void start() {
    System.out.println("Cricket Game Started. Enjoy the game!");
  }

  void end() {
    System.out.println("Cricket Game Finished!");
  }

}

class Football extends Games {

  void init() {
    System.out.println("Football Game Initialized! Start playing.");
  }

  void start() {
    System.out.println("Football Game Started. Enjoy the game!");
  }

  void end() {
    System.out.println("Football Game Finished!");
  }

}

public class TemplateDesignPattern {

  public static void main(String[] args) {
    Games game = new Cricket();
    game.play();
    System.out.println();
    game = new Football();
    game.play();
  }
}
