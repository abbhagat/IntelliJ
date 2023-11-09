import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * Design a Snake & Ladder Game

 * - Design Entity/Domain classes
 * - Design the Game Flow
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

 * Game g = new Game.Builder().addSnake(34,12).addLadder(23,56).addPlayer("Sanjay").build();
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
    private final List<Ladder> ladderList;
    private final List<Snake> snakeList;
    private final List<Player> playerList;
    private final Map<Integer,Integer> ladderMap;
    private final Map<Integer,Integer> snakeMap;

    private Game(Builder builder) {
        this.ladderList = builder.ladderList;
        this.snakeList  = builder.snakeList;
        this.playerList = builder.playerList;
        this.ladderMap  = builder.ladderMap;
        this.snakeMap   = builder.snakeMap;
    }

    public final void play() {
        // Dice Rolling
        label: while (true) {
            for (Player player : playerList) {
                int n = rollDice();
                if (n >= 1 && n <= 6) {
                    player.index += n;
                    if (player.index > 100) {
                        player.index -= n;
                        rollDice();
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

        private final List<Ladder> ladderList = new ArrayList<>();
        private final List<Snake> snakeList = new ArrayList<>();
        private final List<Player> playerList = new ArrayList<>();
        private final Map<Integer,Integer> ladderMap = new HashMap<>();
        private final Map<Integer,Integer> snakeMap = new HashMap<>();

        Game build() {
            return new Game(this);
        }

        public Builder addSnake(int start, int end) {
            Snake snake = new Snake(start, end);
            snakeMap.put(start, end);
            snakeList.add(snake);
            return this;
        }

        public Builder addLadder(int start, int end) {
            Ladder ladder = new Ladder(start, end);
            ladderMap.put(start, end);
            ladderList.add(ladder);
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
        Game g = new Game.Builder().addSnake(34,12).addLadder(23,56).addPlayer("X").addSnake(43,5).addLadder(11,100).addPlayer("Y").build();
        g.play();
    }
}
