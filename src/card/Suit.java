package card;

public enum Suit {
    SPADE("スペード"),
    HEART("ハート"),
    DIAMOND("ダイヤ"),
    CLUB("クラブ");

    private final String mark;

    Suit(final String mark) {
        this.mark = mark;
    }
    public String getMark(){
        return this.mark;
    }
}
