import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DealerTest {

    private Dealer dealer;
    private Player player1;
    private Player player2;
    private Card card1;
    private Card card2;

    @Before
    public void before() {
        dealer = new Dealer();
        player1 = new Player("Rose");
        player2 = new Player("Bob");
        card1 = new Card(Suit.HEART, Rank.QUEEN);
        card2 = new Card(Suit.SPADE, Rank.TWO);
    }

    @Test
    public void addPlayer() {
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        assertEquals(2, dealer.countPlayers());
    }

    @Test
    public void countDealerCards() {
        dealer.addCardToDealerCards(card1);
        dealer.addCardToDealerCards(card2);
        assertEquals(2, dealer.countDealerCards());
    }

    @Test
    public void startGame() {
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.startGame();
        assertEquals(1, dealer.countDealerCards());
        assertEquals(2, player1.countCards());
        assertEquals(2, player2.countCards());
        assertEquals(47, dealer.countDeckSize());
    }

    @Test
    public void goToNextPlayer() {
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.startGame();
        dealer.goToNextPlayer();
        assertEquals(1, dealer.getCurrentPlayerIndex());
    }

    @Test
    public void twistCardToPlayer() {
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.startGame();
        dealer.twistCardToPlayer();
        assertEquals(3, player1.countCards());
    }

    @Test
    public void wrapUpGame() {
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.startGame();
        dealer.goToNextPlayer();
        dealer.goToNextPlayer();
        dealer.wrapUpGame();
        assertNotEquals(1, dealer.countDealerCards());
        assertNotEquals(PlayerState.PLAYING, player1.getPlayerState());
        assertNotEquals(PlayerState.PLAYING, player2.getPlayerState());
    }
}
