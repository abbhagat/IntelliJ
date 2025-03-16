package games;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
class Card {

    String suit, rank;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}


public class CardDeckDesign {

    final static String[] SUIT = {"heart", "spade", "club", "diamond"};
    final static String[] RANK = {"ace", "king", "queen", "jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

    static Map<String, List<String>> suitRankMap = new LinkedHashMap<>();

    public static void createCardMap() {
        for (String r : RANK) {
            List<String> list = new ArrayList<>(Arrays.asList(SUIT));
            suitRankMap.put(r, list);
        }
    }

    public static void sort() {
        List<Card> list = new ArrayList<>();
        for (String r : RANK) {
            for (String s : SUIT) {
                list.add(new Card(r, s));
            }
        }
        List<Card> result = list.stream().sorted(Comparator.comparing(Card::getSuit)).sorted(Comparator.comparing(Card::getRank)).collect(Collectors.toList());
        System.out.println(result);
    }

    private static Card findMax(Card card1, Card card2) {
        String rank1 = card1.getRank();
        String rank2 = card2.getRank();
        for (Map.Entry<String, List<String>> m : suitRankMap.entrySet()) {
            if (m.getKey().equals(rank1)) {
                return card1;
            }
            if (m.getKey().equals(rank2)) {
                return card2;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        createCardMap();
        System.out.println(findMax(new Card("heart", "king"), new Card("spade", "queen")));
        sort();
    }
}