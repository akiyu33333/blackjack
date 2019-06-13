package card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Deck {
    private List<Card> bill;
    {
        bill = new ArrayList<>();
        Arrays.stream(Suit.values()).forEach(s -> IntStream.rangeClosed(1,13).forEach(i -> bill.add(new Card(s,i))));
        Collections.shuffle(bill);
    }

    public Card draw(){
        Card card = bill.get(0);
        bill.remove(0);
        return card;
    }
}
