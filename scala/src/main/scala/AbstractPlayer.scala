abstract class AbstractPlayer(val name: String) {
  val BUST_POINT = 21
  var cardList: List[Card] = List()
  var isBust = false

  private def addCardList(card: Card) = {
    cardList = cardList.::(card)
  }

  def calcScore: Int = {
    val score: Int = {
      var score = 0
      val filterCardList: List[Card] = cardList.filter(_.point > 1)
      for (c <- filterCardList) {
        score = score + c.point
      }
      score
    }
    val aceCardCount: Int = cardList.filter(_.point == 1).size
    if (aceCardCount == 0) return score
    val borderScore = 11 - aceCardCount
    if (score > borderScore) {
      score + aceCardCount
    } else {
      score + 10 + aceCardCount
    }
  }

  def draw(deck: Deck): Unit = {
    draw(deck, false)
  }

  def draw(deck: Deck, isHidden: Boolean): Unit = {
    val card = deck.draw
    addCardList(card)
    if (calcScore > BUST_POINT) isBust = true
    val msg = {
      if (isHidden) {
        name + "の引いたカードはわかりません。"
      } else {
        name + "の引いたカードは" + card.toString() + "です。"
      }
    }
  }

  def initCardList(deck: Deck): Unit

  def drawCard(deck: Deck): Unit
}
