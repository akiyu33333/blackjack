sealed abstract class Suit(val mark: String) {
  def getMark(): String = mark

}

object Suit {

  case object SPADE extends Suit("スペード")

  case object HEART extends Suit("ハート")

  case object DIAMOND extends Suit("ダイヤ")

  case object CLUB extends Suit("クラブ")

  def values: List[Suit] = List(SPADE, HEART, DIAMOND, CLUB)
}


