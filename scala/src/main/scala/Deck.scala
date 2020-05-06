import scala.collection.mutable._
import scala.util.Random

case class Deck() {
  val bill = {
    val cards: Queue[Card] = Queue()
    for (s <- Suit.values; i <- 1 to 13) cards += Card(s, i)
    Random.shuffle(cards)
  }

  def draw = bill.dequeue
}
