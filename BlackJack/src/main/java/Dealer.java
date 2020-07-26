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

    public int countDeckSize() {
        return this.deck.getDeckSize();
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

            if (player.totalCardsValue() == 21) {
                player.setPlayerState(PlayerState.WINNER);
            }
        }
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getPlayerState() == PlayerState.PLAYING) {
                this.currentPlayerIndex = i;
                break;
            }
        }
    }

    public void goToNextPlayer() {
        if (this.currentPlayerIndex == this.players.size() - 1) {
            this.currentPlayerIndex = -1;
        } else {
            for (int i = this.currentPlayerIndex + 1; i < this.players.size(); i++) {
                if (this.players.get(i).getPlayerState() == PlayerState.PLAYING) {
                    this.currentPlayerIndex = i;
                    break;
                }
            }
        }
    }

    public int getCurrentPlayerIndex() {
        return this.currentPlayerIndex;
    }

    public void twistCardToPlayer() {
        Player currentPlayer = this.players.get(this.currentPlayerIndex);
        if (this.currentPlayerIndex != -1 && currentPlayer.getPlayerState() == PlayerState.PLAYING) {
            currentPlayer.twistCard(this.deck.dealCard());
            if (currentPlayer.totalCardsValue() == 21) {
                currentPlayer.setPlayerState(PlayerState.WINNER);
                this.goToNextPlayer();
            } else if (currentPlayer.totalCardsValue() > 21) {
                currentPlayer.setPlayerState(PlayerState.LOSER);
                this.goToNextPlayer();
            }
        }
    }

    public int countDealerCardsValue() {
        int totalValue = 0;
        for (Card dealerCard : this.dealerCards) {
            totalValue += dealerCard.getRankValue();
        }
        return totalValue;
    }

    public void wrapUpGame() {
        if (this.currentPlayerIndex == -1) {
            this.addCardToDealerCards(this.deck.dealCard());
            if (this.countDealerCardsValue() > 21) {
                for (Player player : this.players) {
                    if (player.getPlayerState() == PlayerState.PLAYING) {
                        player.setPlayerState(PlayerState.WINNER);
                    }
                }
            } else if (this.countDealerCardsValue() == 21) {
                for (Player player : this.players) {
                    if (player.getPlayerState() == PlayerState.PLAYING) {
                        player.setPlayerState(PlayerState.LOSER);
                    }
                }
            } else if (this.countDealerCardsValue() >= 17) {
                int dealerScore = this.countDealerCardsValue();
                for (Player player : this.players) {
                    if (player.totalCardsValue() > dealerScore) {
                        player.setPlayerState(PlayerState.WINNER);
                    } else if (player.totalCardsValue() < dealerScore) {
                        player.setPlayerState(PlayerState.LOSER);
                    }
                }
            } else {
                this.addCardToDealerCards(this.deck.dealCard());
                this.wrapUpGame();
            }
        }
    }

    public void printBoard() {
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("Current status:");
        System.out.println("===============");
        System.out.println("Dealer:");
        for (Card dealerCard : this.dealerCards) {
            System.out.println(dealerCard.getRank() + "-" + dealerCard.getSuit());
        }
        System.out.println();
        System.out.println();
        for (Player player : this.players) {
            System.out.println("Player: " + player.getPlayerName() + " (" + player.getPlayerState() + ")");
            for (Card card : player.getCards()) {
                System.out.println(card.getRank() + "-" + card.getSuit());
            }
            System.out.println();
            System.out.println();
        }

        if (this.currentPlayerIndex == -1) {
            System.out.println("Current player: Dealer");
        } else {
            System.out.println("Current player: " + this.players.get(this.currentPlayerIndex).getPlayerName());
        }
    }

    public void printFinalStats() {
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("Dealer cards value: (" + this.countDealerCardsValue() + ")");
        for (Player player : this.players) {
            System.out.println("Player: " + player.getPlayerName() + " (" + player.getPlayerState() + ")");
        }
    }
}