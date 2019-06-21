package player;

import card.Deck;

import java.util.Objects;
import java.util.Scanner;

public class User extends AbstractPlayer {
    public User(String name) {
        super(name);
    }

    @Override
    public void initCardList(Deck deck) {
        draw(deck);
        draw(deck);
    }

    @Override
    public void drawCard(Deck deck) {
        System.out.println( getName() + "の現在の得点は" + calcScore() + "点です。\n");
        try (Scanner sc = new Scanner(System.in)) {
            String line = null;
            while (!isBust() && !Objects.equals(line, "N")) {
                System.out.println("カードを引きますか？引く場合はYを引かない場合はNを入力してください。");
                line = sc.nextLine();
                if (Objects.equals(line, "Y")) {
                    draw(deck);
                    System.out.println( getName() + "の現在の得点は" + calcScore() + "点です。\n");
                } else if (!Objects.equals(line, "N")) {
                    System.out.println("Y/N以外が入力されました。");
                }
            }
        }
    }
}
