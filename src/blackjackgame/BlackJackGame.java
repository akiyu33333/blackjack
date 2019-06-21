package blackjackgame;

import card.Deck;
import player.Dealer;
import player.AbstractPlayer;
import player.User;

public class BlackJackGame {

    /**
     *  ゲーム開始
     */
    public void start() {
        System.out.println("★☆★☆★☆★☆★☆★☆　ブラックジャックにようこそ！　★☆★☆★☆★☆★☆★☆\n");
        System.out.println("ゲームを開始します。\n");

        Deck deck     = new Deck();
        AbstractPlayer user   = new User("あなた");
        AbstractPlayer dealer = new Dealer("ディーラー");

        user.initCardList(deck);
        dealer.initCardList(deck);

        user.drawCard(deck);
        if(!user.isBust()) dealer.drawCard(deck);

        printGameResult(user, dealer);

        System.out.println("\nブラックジャック終了！また遊んでね★");
    }

    /**
     * ゲームの結果を表示
     * @param player1 プレイヤー1
     * @param player2 プレイヤー2
     */
    private void printGameResult(AbstractPlayer player1, AbstractPlayer player2) {
        if (player1.calcScore() == player2.calcScore()) {
            System.out.println("引き分けです。");
            return;
        }
        AbstractPlayer winner = !player1.isBust() && (player2.isBust() || player1.calcScore() > player2.calcScore())
                ? player1
                : player2;
        System.out.println( winner.getName() + "の勝ちです！" );
    }
}
