import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    public static void main(String[] args) throws IOException {
        System.out.println("Let's Play BlackJack!");
        System.out.println("Please, enter number of players");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int playersNumber = Integer.parseInt(reader.readLine());

        Dealer dealer = new Dealer();

       for(int i=0; i<playersNumber; i++) {
           System.out.println("Please, enter player name");
           String playerName = reader.readLine();
           dealer.addPlayer(new Player(playerName));
       }
       dealer.startGame();
       dealer.printBoard();


    }
}
