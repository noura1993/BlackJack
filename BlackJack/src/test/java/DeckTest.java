import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {

    private Deck deck;

    @Before
    public void before() {
        deck = new Deck();
    }

    @Test
    public void deckShouldStartEmpty() {
        assertEquals(0, deck.getDeckSize());
    }

    @Test
    public void canPopulateTheDeckOfCards() {
        deck.populateTheDeck();
        assertEquals(52, deck.getDeckSize());
    }

    @Test
    public void clearsBeforePopulateTheDeckOfCards() {
        deck.populateTheDeck();
        deck.populateTheDeck();
        assertEquals(52, deck.getDeckSize());
    }

    @Test
    public void canShuffleCards() {
        deck.populateTheDeck();
        Card card1 = deck.getFirstCard();
        deck.shuffleCards();
        Card card2 = deck.getFirstCard();
        assertNotEquals(card2, card1);
    }
}
