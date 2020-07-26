import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card1;
    private Card card2;

    @Before
    public void before() {
        player = new Player("Rose");
        card1 = new Card(Suit.HEART, Rank.QUEEN);
        card2 = new Card(Suit.SPADE, Rank.TWO);
    }

    @Test
    public void getPlayerName() {
        assertEquals("Rose", player.getPlayerName());
    }

    @Test
    public void canTwistCard() {
        player.twistCard(card1);
        assertEquals(1, player.countCards());
    }

    @Test
    public void totalCardsValue() {
        player.twistCard(card1);
        player.twistCard(card2);
        assertEquals(12, player.totalCardsValue());
    }

    @Test
    public void changePlayerState() {
        PlayerState state = PlayerState.WINNER;
        player.setPlayerState(state);
        assertEquals(state, player.getPlayerState());
    }

}
