case class Card(val suit: Suit, val rank: Int) {

  def toDisplayValue = {
    rank match {
      case 1 => "A"
      case 11 => "J"
      case 12 => "Q"
      case 13 => "K"
      case _ => rank.toString
    }
  }

  def point = if (rank > 10) 10 else rank

  override def toString= suit.mark + "の" + toDisplayValue
}
