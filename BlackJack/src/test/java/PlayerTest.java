import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card;

    @Before
    public void before() {
        player = new Player();
        card = new Card(Suit.HEART, Rank.QUEEN);
    }

    @Test
    public void canTwistCard() {
        player.twistCard(card);
        assertEquals(1, player.countCards());
    }

}
