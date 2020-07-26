import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public int getDeckSize() {
        return this.deck.size();
    }

    public void populateTheDeck() {
        this.deck.clear();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.deck.add(new Card(suit, rank));
            }
        }
        this.shuffleCards();

    }

    public Card getFirstCard() {
        return this.deck.get(0);
    }

    public void shuffleCards() {
        Collections.shuffle(this.deck);
    }
}
