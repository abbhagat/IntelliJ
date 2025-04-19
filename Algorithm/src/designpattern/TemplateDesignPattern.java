package designpattern;

/**
 * In Template pattern, an abstract class exposes defined way(s)/template(s)
 * to execute its methods. Its subclasses can override the method implementation
 * as per need, but the invocation is to be in the same way as defined by an
 * abstract class.
 */

abstract class Games {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Games {

    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

}

class Football extends Games {

    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    void endPlay() {
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
