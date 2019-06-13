package judge;

import card.Deck;
import player.PlayerBase;

import java.util.Objects;
import java.util.Scanner;

public class Judge {

    /**
     *  ゲーム開始
     */
    public void gameStart() {
        System.out.println("★☆★☆★☆★☆★☆★☆　ブラックジャックにようこそ！　★☆★☆★☆★☆★☆★☆\n");
        System.out.println("ゲームを開始します。\n");

        Deck deck = new Deck();
        PlayerBase user   = new PlayerBase("あなた");
        PlayerBase dealer = new PlayerBase("ディーラー");

        initDraw(user,  deck);
        initDraw(dealer,deck);

        drawCardByUser(user,deck);
        drawCardByDealer(dealer,deck);

        printGameResult(user, dealer);

        System.out.println("\nブラックジャック終了！また遊んでね★");
    }

    /**
     * ゲームの結果を表示
     * @param user   ユーザー
     * @param dealer ディーラー
     */
    private void printGameResult(PlayerBase user, PlayerBase dealer) {
        if ((user.isBust() && dealer.isBust() )
                || user.getPoint() == dealer.getPoint()) {
            System.out.println("引き分けです。");
        } else if (!user.isBust() && dealer.isBust() && user.getPoint() > dealer.getPoint()) {
            System.out.println("あなたの勝ちです！");
        } else {
            System.out.println("ディーラーの勝ちです！");
        }
    }

    /**
     * 最初の手札は2回カードを引く
     * @param player プレイヤー
     * @param deck   山札
     */
    private void initDraw(PlayerBase player, Deck deck) {
        player.draw(deck);
        player.draw(deck);
        System.out.println( player.getName() + "の現在の得点は" + player.getPoint() + "点です。\n");
    }
    /**
     * ユーザーのドローターン
     * @param user ユーザー
     * @param deck 山札
     */
    private void drawCardByUser(PlayerBase user, Deck deck) {
        try (Scanner sc = new Scanner(System.in)) {
            String line = null;
            while (user.isBust() || !Objects.equals(line, "N")) {
                System.out.println("カードを引きますか？引く場合はYを引かない場合はNを入力してください。");
                line = sc.nextLine();
                if (Objects.equals(line, "Y")) {
                    user.draw(deck);
                    System.out.println("あなたの現在の得点は" + user.getPoint() + "点です。\n");
                } else if (!Objects.equals(line, "N")) {
                    System.out.println("Y/N以外が入力されました。");
                }
            }
        }
    }

    /**
     * ディーラーのドローターン
     * @param dealer ディーラー
     * @param deck   山札
     */
    private void drawCardByDealer(PlayerBase dealer, Deck deck) {
        while (dealer.getPoint() < 17){
            dealer.draw(deck);
            System.out.println("ディーラーの現在の得点は" + dealer.getPoint() + "点です。\n");
        }
    }

}
