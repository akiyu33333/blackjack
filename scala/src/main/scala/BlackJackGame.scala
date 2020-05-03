case class BlackJackGame() {
  def start(): Unit = {
    println("★☆★☆★☆★☆★☆★☆　ブラックジャックにようこそ！　★☆★☆★☆★☆★☆★☆\n")
    println("ゲームを開始します。\n")

    val deck: Deck = Deck()
    val user: AbstractPlayer = User("あなた")
    val dealer: AbstractPlayer = Dealer("ディーラー")

    user.initCardList(deck)
    dealer.initCardList(deck)

    user.drawCard(deck)
    if (!user.isBust) {
      dealer.drawCard(deck)
    }

    printGameResult(user, dealer)

    println("\nブラックジャック終了！また遊んでね★")
  }

  def printGameResult(player1: AbstractPlayer, player2: AbstractPlayer): Unit = {
    if (player1.calcScore() == player2.calcScore()) {
      println("引き分けです。")
      return
    }
    val winner: AbstractPlayer = if (!player1.isBust && (player2.isBust || player1.calcScore() > player2.calcScore())) {
      player1
    } else {
      player2
    }
    println(winner.name + "の勝ちです！")
  }
}
