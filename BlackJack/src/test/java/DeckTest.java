import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
