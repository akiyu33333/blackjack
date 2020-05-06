case class Dealer(override val name: String) extends AbstractPlayer(name) {
  override def initCardList(deck: Deck) = {
    draw(deck)
    draw(deck, true)
  }

  override def drawCard(deck: Deck) = {
    println(s"${name}の現在の得点は${calcScore}点です。\n")
    while (calcScore < 17) {
      draw(deck)
      println(s"${name}の現在の得点は${calcScore}点です。\n")
    }
  }
}
