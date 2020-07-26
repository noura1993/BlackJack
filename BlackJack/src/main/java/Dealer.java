import java.util.ArrayList;

public class Dealer {

    private Deck deck;
    private ArrayList<Player> players;
    private ArrayList<Card> dealerCards;
    private int currentPlayerIndex = -1;

    public Dealer() {
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
        this.dealerCards = new ArrayList<Card>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int countPlayers() {
        return this.players.size();
    }

    public void addCardToDealerCards(Card card) {
        this.dealerCards.add(card);
    }

    public int countDealerCards() {
        return this.dealerCards.size();
    }

    public void startGame() {
        this.deck.populateTheDeck();
        this.dealerCards.add(this.deck.dealCard());
        for (Player player : this.players) {
            player.twistCard(this.deck.dealCard());
            player.twistCard(this.deck.dealCard());

            if(player.totalCardsValue() == 21) {
                player.setPlayerState(PlayerState.WINNER);
            }
        }
    }
}
