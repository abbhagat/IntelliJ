package games;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
class Player {
  String name;
  int index;
}

@AllArgsConstructor
class Snake {
  int start, end;
}

@AllArgsConstructor
class Ladder {
  int start, end;
}

class Game {

  private final List<Player> playerList;
  private final Map<Integer, Integer> ladderMap;
  private final Map<Integer, Integer> snakeMap;

  private Game(Builder builder) {
    this.playerList = builder.playerList;
    this.ladderMap = builder.ladderMap;
    this.snakeMap = builder.snakeMap;
  }

  public final void play() {
    int round = 1;
    while (round != 0) {
      System.out.println("-------------------");
      System.out.println("Round : " + round++);
      for (Player player : playerList) {
        int n = rollDice();
        System.out.println(player.name + " rolled " + n);
        player.index += n;
        while (player.index > 100) {
          System.out.println(player.name + " index exceeded 100 so rolling dice again");
          player.index -= n;
          n = rollDice();
          System.out.println(player.name + " rolled " + n);
          player.index += n;
        }
        System.out.println(player.name + " moved to " + player.index);
        if (ladderMap.containsKey(player.index)) {
          player.index = ladderMap.get(player.index);
          System.out.println(player.name + " climbed ladder to " + player.index);
        }
        if (snakeMap.containsKey(player.index)) {
          player.index = snakeMap.get(player.index);
          System.out.println(player.name + " bitten by snake to " + player.index);
        }
        if (player.index == 100) {
          System.out.println(player.name + " is winner");
          return;
        }
      }
    }
  }

  public int rollDice() {
    return new Random().nextInt(6) + 1;  //  random.nextInt(6) generates a random integer from 0 to 5.
  }

  public static class Builder {

    private final List<Player> playerList = new ArrayList<>();
    private final Map<Integer, Integer> ladderMap = new HashMap<>();
    private final Map<Integer, Integer> snakeMap = new HashMap<>();

    Game build() {
      return new Game(this);
    }

    public Builder addSnake(int start, int end) {
      snakeMap.put(start, end);
      return this;
    }

    public Builder addLadder(int start, int end) {
      ladderMap.put(start, end);
      return this;
    }

    public Builder addPlayer(String name) {
      Player player = new Player(name, 0);
      playerList.add(player);
      return this;
    }
  }
}

public class SnakeLadderGame {

  public static void main(String[] args) throws InterruptedException {
    Game g = new Game.Builder()
        .addSnake(99, 10).addSnake(52, 5)
        .addSnake(35, 12).addSnake(68, 3)
        .addSnake(75, 28).addSnake(86, 37)
        .addLadder(10, 98).addLadder(12, 55)
        .addLadder(25, 76).addLadder(36, 62)
        .addLadder(45, 89).addLadder(66, 95)
        .addLadder(45, 100).addLadder(25, 95)
        .addPlayer("X")
        .addPlayer("Y")
        .build();
    g.play();
  }
}
