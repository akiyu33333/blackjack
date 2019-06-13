package judge;

import card.Deck;
import player.Player;

import java.util.Objects;
import java.util.Scanner;

public class Judge {

    /**
     *  ゲーム開始
     */
    public void gameStart() {
        System.out.println("★☆★☆★☆★☆★☆★☆　ブラックジャックにようこそ！　★☆★☆★☆★☆★☆★☆\n");
        System.out.println("ゲームを開始します。\n");

        Deck deck     = new Deck();
        Player user   = new Player("あなた");
        Player dealer = new Player("ディーラー");

        initDrawByUser(user, deck);
        initDrawByCpuPlayer(dealer, deck);

        drawCardByUser(user, deck);
        if(!user.isBust()) drawCardByCpuPlayer(dealer, deck);

        printGameResult(user, dealer);

        System.out.println("\nブラックジャック終了！また遊んでね★");
    }

    /**
     * ゲームの結果を表示
     * @param player1 プレイヤー1
     * @param player2 プレイヤー2
     */
    private void printGameResult(Player player1, Player player2) {
        if (player1.getPoint() == player2.getPoint()) {
            System.out.println("引き分けです。");
            return;
        }
        Player winner = !player1.isBust() && (player2.isBust() || player1.getPoint() > player2.getPoint())
                ? player1
                : player2;
        System.out.println( winner.getName() + "の勝ちです！" );
    }

    /**
     * 最初の手札は2回カードを引く
     * @param player プレイヤー
     * @param deck   山札
     */
    private void initDrawByUser(Player player, Deck deck) {
        player.draw(deck);
        player.draw(deck);
    }

    /**
     * CPUの最初の手札
     * 2枚目は何を引いたかわからない
     * @param cpuPlayer
     * @param deck
     */
    private void initDrawByCpuPlayer(Player cpuPlayer, Deck deck) {
        cpuPlayer.draw(deck);
        cpuPlayer.draw(deck, true);
    }

    /**
     * ユーザーのドローターン
     * @param user ユーザー
     * @param deck 山札
     */
    private void drawCardByUser(Player user, Deck deck) {

        System.out.println( user.getName() + "の現在の得点は" + user.getPoint() + "点です。\n");

        try (Scanner sc = new Scanner(System.in)) {
            String line = null;
            while (!user.isBust() && !Objects.equals(line, "N")) {
                System.out.println("カードを引きますか？引く場合はYを引かない場合はNを入力してください。");
                line = sc.nextLine();
                if (Objects.equals(line, "Y")) {
                    user.draw(deck);
                    System.out.println(user.getName() + "の現在の得点は" + user.getPoint() + "点です。\n");
                } else if (!Objects.equals(line, "N")) {
                    System.out.println("Y/N以外が入力されました。");
                }
            }
        }
    }

    /**
     * CPUのドローターン
     * @param cpuPlayer CPU
     * @param deck      山札
     */
    private void drawCardByCpuPlayer(Player cpuPlayer, Deck deck) {
        while (cpuPlayer.getPoint() < 17){
            cpuPlayer.draw(deck);
            System.out.println( cpuPlayer.getName() + "の現在の得点は" + cpuPlayer.getPoint() + "点です。\n");
        }
    }

}
