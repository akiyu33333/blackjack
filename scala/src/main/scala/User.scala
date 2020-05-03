case class User(override val name: String) extends AbstractPlayer(name) {
  override def initCardList(deck: Deck): Unit = {
    draw(deck)
    draw(deck)
  }

  override def drawCard(deck: Deck): Unit = {
    println(name + "の現在の得点は" + calcScore + "点です。\n")
    var line: String = null
    while (!isBust && "N" != line) {
      println("カードを引きますか？引く場合はYを引かない場合はNを入力してください。")
      line = readLine()
      if ("Y" == line) {
        draw(deck)
        println(name + "の現在の得点は" + calcScore + "点です。\n")
      } else if ("N" != line) {
        println("Y/N以外が入力されました。")
      }
    }
  }
}
