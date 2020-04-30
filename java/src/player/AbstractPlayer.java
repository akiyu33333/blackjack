package player;

import card.Card;
import card.Deck;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer {
    protected static final int BUST_POINT = 21;

    @Getter
    private final String name;
    private List<Card> cardList = new ArrayList<>();
    //TODO:ゲームの終了フラグはゲームごとに持つべき
    @Getter
    @Setter
    private boolean isBust = false;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    private void addCardList(Card card){
        cardList.add(card);
    }

    //TODO:
    //計算式はブラックジャック固有なのでここに定義するべきではない
    public int calcScore(){
        int score = cardList.stream().filter(card -> card.getPoint() > 1 ).mapToInt(card -> card.getPoint()).sum();
        int aceCardCount = (int) cardList.stream().filter(card -> card.getPoint() == 1 ).count();
        if (aceCardCount == 0) return score;
        int borderScore = 11 - aceCardCount;
        return score > borderScore ? score + aceCardCount : score + 10 + aceCardCount ;
    }

    public void draw(Deck deck) {
        draw(deck,false);
    }

    //TODO:
    //このメソッドはプレイヤーに定義する汎用的な内容ではないのでここに定義するべきではない
    /**
     * 山札からカードを引く
     * @param deck     山札
     * @param isHidden 引いたカードをを隠すか
     */
    public void draw(Deck deck, boolean isHidden) {
        Card card = deck.draw();
        addCardList(card);
        if (calcScore() > BUST_POINT) setBust(true);
        String msg = isHidden
                ? this.name + "の引いたカードはわかりません。"
                : this.name + "の引いたカードは" + card.toString() + "です。";
        System.out.println( msg );
    }

    /**
     * 初期手札の作成
     * @param deck 山札
     */
    public abstract void initCardList(Deck deck);

    /**
     * 山札からカードを引く
     * @param deck 山札
     */
    public abstract void drawCard(Deck deck);
}
