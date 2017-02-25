import model._
import org.scalacheck.Gen
import org.scalatest.FunSpec
import org.scalacheck.Prop.forAll
import org.scalatest.prop.Checkers

class BoardSpec extends FunSpec with Checkers {
  describe("A Board") {

    it("should initialize all cells to dead") {
      val b = new Board(100)
      assert(b.positions.forall(b.getCell(_) == Dead))
    }

    it("should set live cells when required") {
      val b = new Board(100)
      val somePositions = for {
        x <- Gen.choose(0, b.dimension - 1)
        y <- Gen.choose(0, b.dimension - 1)
      } yield Position(x, y)

      somePositions.map(p => b.setCell(Live, p))

      forAll(somePositions) { (p) =>
        b.getCell(p) == Live
      }.check
    }
  }
}
