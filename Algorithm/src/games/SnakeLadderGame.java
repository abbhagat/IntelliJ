package games;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * Design a games.Snake & games.Ladder games.Game

 * - Design Entity/Domain classes
 * - Design the games.Game Flow
 * - Use the Design Patterns wherever applicable

 * init()
 * 1. user create a game
 * 2. addPlayer()
 * 3. addSnakes()
 * 4. addLadders()

 * start() {
 * roll the dice
 * randome number 1- 6;
 * check for snakes -> new position
 * check for ladder -> if 100 winner
 * run in loop() till the game ends
 * }

 * end() {
 * end the game
 * }

 * games.Game g = new games.Game.Builder().addSnake(34,12).addLadder(23,56).addPlayer("Sanjay").build();
 * g.play()
 */

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
    private final Map<Integer,Integer> ladderMap;
    private final Map<Integer,Integer> snakeMap;

    private Game(Builder builder) {
        this.playerList = builder.playerList;
        this.ladderMap  = builder.ladderMap;
        this.snakeMap   = builder.snakeMap;
    }

    public final void play() {
        label: while (true) {
            for (Player player : playerList) {
                int n = rollDice();
                if (n >= 1 && n <= 6) {
                    player.index += n;
                    while (player.index > 100) {
                        player.index -= n;
                        n = rollDice();
                        player.index += n;
                    }
                    if (ladderMap.containsKey(player.index)) {
                        player.index = ladderMap.get(player.index);
                    }
                    if (snakeMap.containsKey(player.index)) {
                        player.index = snakeMap.get(player.index);
                    }
                    if (player.index == 100) {
                        System.out.println(player.name + " is winner");
                        break label;
                    }
                } else {
                    rollDice();
                }
            }
        }
    }

    public int rollDice() {
        return new Random().nextInt(6);
    }

    public static class Builder {
        private final List<Player> playerList = new ArrayList<>();
        private final Map<Integer,Integer> ladderMap = new HashMap<>();
        private final Map<Integer,Integer> snakeMap = new HashMap<>();

        public Game build() {
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

    public static void main(String[] args) {
        Game g = new Game.Builder()
                .addSnake(34,12).addLadder(23,56).addPlayer("X")
                .addSnake(43,5).addLadder(11,100).addPlayer("Y")
                .build();
        g.play();
    }
}
