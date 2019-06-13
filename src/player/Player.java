package player;

import card.Card;
import card.Deck;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Player {
    protected static final int BUST_POINT = 21;

    @Getter
    private final String name;
    private List<Card> cardList = new ArrayList<>();
    @Getter
    @Setter
    private boolean isBust = false;

    public Player(String name) {
        this.name = name;
    }

    private void addCardList(Card card){
        cardList.add(card);
    }

    public int getPoint(){
        return cardList.stream().mapToInt( card -> card.getPoint()).sum();
    }

    public void draw(Deck deck) {
        draw(deck,false);
    }

    /**
     * 山札からカードを引く
     * @param deck     山札
     * @param isHidden 引いたカードをを隠すか
     */
    public void draw(Deck deck, boolean isHidden) {
        Card card = deck.draw();
        addCardList(card);
        if (getPoint() > BUST_POINT) setBust(true);
        String msg = isHidden
                ? this.name + "の引いたカードはわかりません。"
                : this.name + "の引いたカードは" + card.toString() + "です。";
        System.out.println( msg );
    }

}
