import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card playCard(Card topDiscard) {
        for (Card card : hand) {
            if (card.isPlayable(topDiscard)) {
                hand.remove(card);
                return card;
            }
        }
        throw new IllegalStateException("No playable card found.");
    }

    public boolean hasPlayableCard(Card topDiscard) {
        for (Card card : hand) {
            if (card.isPlayable(topDiscard)) {
                return true;
            }
        }
        return false;
    }
}