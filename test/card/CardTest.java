package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getPoint01() {
        Card card = new Card(Suit.CLUB, 2);
        assertEquals(card.getPoint() , 2);
    }
    @Test
    void getPoint02() {
        Card card = new Card(Suit.DIAMOND, 13);
        assertEquals(card.getPoint() , 10);
    }
    @Test
    void getPoint03() {
        Card card = new Card(Suit.HEART, 10);
        assertEquals(card.getPoint() , 10);
    }
    @Test
    void getPoint04() {
        Card card = new Card(Suit.SPADE, 11);
        assertEquals(card.getPoint() , 10);
    }

    @Test
    void toString1() {
        Card card = new Card(Suit.SPADE, 11);
        assertEquals(card.toString() , Suit.SPADE.getMark()+"のJ");
    }
    @Test
    void toString2() {
        Card card = new Card(Suit.SPADE, 1);
        assertEquals(card.toString() , Suit.SPADE.getMark()+"のA");
    }
    @Test
    void toString3() {
        Card card = new Card(Suit.SPADE, 12);
        assertEquals(card.toString() , Suit.SPADE.getMark()+"のQ");
    }
    @Test
    void toString4() {
        Card card = new Card(Suit.SPADE, 13);
        assertEquals(card.toString() , Suit.SPADE.getMark()+"のK");
    }
    @Test
    void toString5() {
        Card card = new Card(Suit.SPADE, 6);
        assertEquals(card.toString() , Suit.SPADE.getMark()+"の6");
    }
}