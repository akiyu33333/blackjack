package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void draw() {
        Deck deck = new Deck();
        Card card = deck.draw();
        assertNotNull(card);
    }
}