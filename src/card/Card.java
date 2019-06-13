package card;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Card {

    private final Suit suit;
    private final int rank;

    private String toDisplayValue() {
        switch (this.rank) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(this.rank);
        }
    }
    public int getPoint() {
        return this.rank > 10 ? 10 : this.rank;
    }
    @Override
    public String toString() {
        return this.suit.getMark() + "の" + this.toDisplayValue();
    }

}
