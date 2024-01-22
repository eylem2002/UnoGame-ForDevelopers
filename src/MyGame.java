import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class MyGame extends Game {
    public MyGame(List<Player> players) {
        super(players);
    }

    @Override
    protected void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayGameState();
            Player currentPlayer = players.get(0);
            Card topDiscard = discardPile.get(discardPile.size() - 1);

            System.out.println(currentPlayer.getName() + ", it's your turn!");

            if (currentPlayer.hasPlayableCard(topDiscard)) {
                Card playedCard = currentPlayer.playCard(topDiscard);
                System.out.println(currentPlayer.getName() + " plays " + playedCard);

                handleSpecialCards(playedCard);


                if (currentPlayer.getHand().isEmpty()) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }


                Collections.rotate(players, clockwise ? -1 : 1);
            } else {

                currentPlayer.addCard(drawCard());
                System.out.println(currentPlayer.getName() + " has no playable cards and draws a card.");


                Collections.rotate(players, clockwise ? -1 : 1);
            }
        }
    }

    private void handleSpecialCards(Card playedCard) {
        switch (playedCard.getValue()) {
            case "Skip":
                skipNextPlayer();
                break;
            case "Reverse":
                reversePlayDirection();
                skipNextPlayer();
                break;
            case "Draw Two":
                drawTwoNextPlayer();
                skipNextPlayer();
                break;
            case "Wild":
                handleWildCard();
                break;
            case "Wild Draw Four":
                handleWildDrawFourCard();
                break;

            default:

        }
    }

    @Override
    protected void reversePlayDirection() {
        clockwise = !clockwise;
    }

    @Override
    protected void skipNextPlayer() {
        Collections.rotate(players, clockwise ? -2 : 2); 
    }

    @Override
    protected void drawTwoNextPlayer() {
        Player nextPlayer = players.get(clockwise ? 1 : players.size() - 1);
        for (int i = 0; i < 2; i++) {
            nextPlayer.addCard(drawCard());
        }
    }

    @Override
    protected void handleWildCard() {
        System.out.println("MyGame: Choose a color for the Wild card: (Red, Green, Blue, Yellow)");
        Scanner scanner = new Scanner(System.in);
        String chosenColor = scanner.next();
        discardPile.get(discardPile.size() - 1).setColor(chosenColor);
    }

    @Override
    protected void handleWildDrawFourCard() {
        handleWildCard();
        Player nextPlayer = players.get(clockwise ? 1 : players.size() - 1);
        for (int i = 0; i < 4; i++) {
            nextPlayer.addCard(drawCard());
        }
    }
}
