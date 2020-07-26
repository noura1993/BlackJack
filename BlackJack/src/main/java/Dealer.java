import java.util.ArrayList;

public class Dealer {

    private Deck deck;
    private ArrayList<Player> players;
    private ArrayList<Card> dealerCards;
    private Player currentPlayer;

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
}
