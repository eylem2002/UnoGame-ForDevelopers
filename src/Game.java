import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

abstract class Game {
    protected List<Player> players;
    protected List<Card> drawPile;
    protected List<Card> discardPile;
    protected boolean clockwise;

    public Game(List<Player> players) {
        this.players = players;
        this.drawPile = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.clockwise = true;
        initializeDeck();
        shuffleDeck();
        dealCards();
    }

    protected abstract void play();

    private void initializeDeck() {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};
        String[] wildValues = {"Wild", "Wild Draw Four"};

        for (String color : colors) {
            for (String value : values) {
                for (int i = 0; i < 2; i++) {
                    drawPile.add(new Card(color, value));
                }
            }
        }

        for (String wildValue : wildValues) {
            for (int i = 0; i < 4; i++) {
                drawPile.add(new Card("Wild", wildValue));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(drawPile);
    }

    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.addCard(drawCard());
            }
        }
    }

    protected Card drawCard() {
        if (drawPile.isEmpty()) {
            reshuffleDiscardPile();
        }
        Card card = drawPile.remove(0);
        discardPile.add(card);
        return card;
    }

    private void reshuffleDiscardPile() {
        Collections.shuffle(discardPile);
        drawPile.addAll(discardPile.subList(1, discardPile.size()));
        discardPile.clear();
    }

    protected void displayGameState() {
        System.out.println("Current Discard Pile: " + discardPile.get(discardPile.size() - 1));
        for (Player player : players) {
            System.out.println(player.getName() + "'s Hand: " + player.getHand());
        }
    }

    protected  abstract void reversePlayDirection() ;

    protected  abstract void skipNextPlayer();

    protected abstract void drawTwoNextPlayer() ;
    protected abstract void handleWildCard();

    protected abstract void handleWildDrawFourCard();
}