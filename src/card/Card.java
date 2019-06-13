package card;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Card {

    private final Suit suit;
    private final int number;

    private String toNoString() {
        switch (this.number) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(this.number);
        }
    }
    public int getPoint() {
        return this.number > 10 ? 10 : this.number;
    }
    @Override
    public String toString() {
        return this.suit.getMark() + "の" + this.toNoString();
    }

}
