import java.util.ArrayList;

public class Player {

    private ArrayList<Card> playerCards;
    private PlayerState playerState;

    public Player() {
        this.playerCards = new ArrayList<Card>();
        this.playerState = PlayerState.PLAYING;
    }

    public int countCards() {
        return this.playerCards.size();
    }

    public void twistCard(Card card) {
        this.playerCards.add(card);
    }


}
