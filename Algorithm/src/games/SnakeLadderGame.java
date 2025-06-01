package games;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 Design a Snake & Ladder Game

 - Design Entity/Domain classes
 - Design the Game Flow
 - Use the Design Patterns wherever applicable

 Init()
 1. User creates game
 2. addPlayer()
 3. addSnakes()
 4. addLadders()

 Start() {
 roll the dice
 random number 1-6;
 check for snakes -> new position
 check for ladder -> if 100 winners
 run in loop() till the game ends
 }

 End() {
 end the game
 }
 Game g = new Game.Builder().addSnake(34,12).addLadder(23,56).addPlayer("Sanjay").build();
 g.play()
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
    private final Map<Integer, Integer> ladderMap;
    private final Map<Integer, Integer> snakeMap;

    private Game(Builder builder) {
        this.playerList = builder.playerList;
        this.ladderMap  = builder.ladderMap;
        this.snakeMap   = builder.snakeMap;
    }

    public final void play() throws InterruptedException {
        while (true) {
            for (Player player : playerList) {
                Thread.sleep(1000);
                int n = rollDice();
                System.out.println(player.name + " rolled " + n);
                player.index += n;
                while (player.index > 100) {
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
                .addPlayer("X")
                .addPlayer("Y")
                .build();
        g.play();
    }
}
