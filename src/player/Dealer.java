package player;

import card.Deck;

public class Dealer extends AbstractPlayer {

    public Dealer(String name) {
        super(name);
    }

    @Override
    public void initCardList(Deck deck) {
        draw(deck);
        draw(deck, true);
    }
    @Override
    public void drawCard(Deck deck) {
        System.out.println( getName() + "の現在の得点は" + calcScore() + "点です。\n");
        while (calcScore() < 17){
            draw(deck);
            System.out.println( getName() + "の現在の得点は" + calcScore() + "点です。\n");
        }
    }
}
