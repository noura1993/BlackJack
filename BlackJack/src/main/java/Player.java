import java.util.ArrayList;

public class Player {

    private final ArrayList<Card> playerCards;
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

    public int totalCardsValue() {
        int totalValue = 0;
        for (Card playerCard : this.playerCards) {
            totalValue += playerCard.getRankValue();
        }
        return totalValue;
    }

    public PlayerState getPlayerState() {
        return this.playerState;
    }

    public void setPlayerState(PlayerState state) {
        this.playerState = state;
    }

}
