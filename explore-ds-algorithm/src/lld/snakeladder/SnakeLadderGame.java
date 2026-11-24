package lld.snakeladder;

import java.util.*;

class Player {
  String name;
  int position;

  Player(String name) {
    this.name = name;
    this.position = 0;
  }
}

class Game {

  private final List<Player> players;
  private final Map<Integer, Integer> snakes;
  private final Map<Integer, Integer> ladders;

  private final Random random = new Random();

  private Game(Builder builder) {
    players = builder.players;
    snakes = builder.snakes;
    ladders = builder.ladders;
  }

  public void play() {
    while (true) {
      for (Player player : players) {
        int dice = rollDice();
        System.out.println(player.name + " rolled " + dice);
        int nextPosition = player.position + dice;
        // Check board boundary
        if (nextPosition > 100) {
          System.out.println(player.name + " cannot move");
          continue;
        }
        player.position = nextPosition;
        // Check ladder
        if (ladders.containsKey(player.position)) {
          player.position = ladders.get(player.position);
          System.out.println(player.name + " climbed ladder to " + player.position);
        }
        // Check snake
        else if (snakes.containsKey(player.position)) {
          player.position = snakes.get(player.position);
          System.out.println(player.name + " bitten by snake to " + player.position);
        }
        System.out.println(player.name + " is at " + player.position);
        // Check winner
        if (player.position == 100) {
          System.out.println(player.name + " is winner!");
          return;
        }
      }
    }
  }

  private int rollDice() {
    return random.nextInt(6) + 1;
  }

  public static class Builder {
    private final List<Player> players          = new ArrayList<>();
    private final Map<Integer, Integer> snakes  = new HashMap<>();
    private final Map<Integer, Integer> ladders = new HashMap<>();

    public Builder addPlayer(String name) {
      players.add(new Player(name));
      return this;
    }

    public Builder addSnake(int start, int end) {
      snakes.put(start, end);
      return this;
    }

    public Builder addLadder(int start, int end) {
      ladders.put(start, end);
      return this;
    }

    public Game build() {
      return new Game(this);
    }
  }
}

public class SnakeLadderGame {

  public static void main(String[] args) {
    Game game = new Game.Builder()
                        .addSnake(99, 10)
                        .addSnake(52, 5)
                        .addSnake(35, 12)
                        .addSnake(68, 3)
                        .addSnake(75, 28)
                        .addSnake(86, 37)
                        .addLadder(10, 98)
                        .addLadder(12, 55)
                        .addLadder(25, 76)
                        .addLadder(36, 62)
                        .addLadder(45, 89)
                        .addLadder(66, 95)
                        .addPlayer("X")
                        .addPlayer("Y")
                        .build();
    game.play();
  }
}
