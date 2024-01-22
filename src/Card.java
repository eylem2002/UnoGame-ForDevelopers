class Card {
    private String color;
    private String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public boolean isPlayable(Card topDiscard) {
        return color.equals(topDiscard.color) || value.equals(topDiscard.value) || color.equals("Wild");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
