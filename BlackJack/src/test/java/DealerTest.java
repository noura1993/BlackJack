import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;
    private Player player1;
    private Player player2;

    @Before
    public void before() {
        dealer = new Dealer();
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
    }

    @Test
    public void addPlayer() {
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        assertEquals(2, dealer.countPlayers());
    }

}
