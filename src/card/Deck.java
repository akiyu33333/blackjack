package card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {
    private List<Card> bill;
    {
        bill = Arrays.stream(Suit.values()).flatMap(s -> IntStream.rangeClosed(1,13).mapToObj(i -> new Card(s,i))).collect(Collectors.toList());
        Collections.shuffle(bill);
    }

    public Card draw(){
        return bill.remove(0);
    }
}
