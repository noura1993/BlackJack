import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public int getDeckSize() {
        return this.deck.size();
    }

    public void populateTheDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.deck.add(new Card(suit, rank));
            }
        }
    }


}
