import scala.util.Random

class Deck {
  var bill = {
    var cards: List[Card] = List()
    for (s <- Suit.values) {
      for (i <- 1 to 13) {
        cards = cards.::(new Card(s, i))
      }
    }
    Random.shuffle(cards)
  }

  def draw(): Card = {
    val c: Card = bill.head
    bill = bill.filterNot(_ == c)
    c
  }
}
