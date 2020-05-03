sealed abstract class Suit(val mark: String)

object Suit {

  case object SPADE extends Suit("スペード")

  case object HEART extends Suit("ハート")

  case object DIAMOND extends Suit("ダイヤ")

  case object CLUB extends Suit("クラブ")

  def values = List(SPADE, HEART, DIAMOND, CLUB)
}


