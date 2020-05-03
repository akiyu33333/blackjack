case class Card(val suit: Suit, val rank: Int) {

  def toDisplayValue(): String = {
    rank match {
      case 1 => "A"
      case 11 => "J"
      case 12 => "Q"
      case 13 => "K"
      case _ => rank.toString
    }
  }

  def getPoint(): Int = {
    if (rank > 10) 10 else rank
  }

  override def toString: String = {
    suit.getMark() + "の" + toDisplayValue()
  }
}
