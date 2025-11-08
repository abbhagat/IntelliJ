package games;

import static util.CommonUtils.swap;

public class DeckOfCards {

    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int N = SUITS.length * RANKS.length;

    private static final String[] deck = new String[N];

    public static void main(String[] args) {
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
        for (int i = 0; i < N; i++) {
            int j = i + (int) (Math.random() * (N - i));
            swap(deck, i, j);
        }
        for (String s : deck) {
            System.out.println(s);
        }
    }
}
