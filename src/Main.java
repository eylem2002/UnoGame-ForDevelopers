import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



                Player player1 = new Player("Leen");
                Player player2 = new Player("Ali");

                List<Player> players = new ArrayList<>();
                players.add(player1);
                players.add(player2);

              //  MyGame myGame = new MyGame(players);
            //    myGame.play();

        MyGame anotherGame = new MyGame(players);
        anotherGame.play();
    }
}