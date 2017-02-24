import model.{Dead, Live, RuleEngine}
import org.scalatest.FunSpec

class RuleEngineSpec extends FunSpec {

  describe("A RuleEngine") {

    it("should kill any live cell with no live neighbour") {
      assert(RuleEngine.nextState(Live, List(Dead)) == Dead)
    }

    it("should kill any live cell with one live neighbour") {
      assert(RuleEngine.nextState(Live, List(Live)) == Dead)
    }

    it("should keep alive any live cell with two live neighbours") {
      assert(RuleEngine.nextState(Live, List(Live, Live)) == Live)
    }

    it("should keep alive any live cell with three live neighbours") {
      assert(RuleEngine.nextState(Live, List(Live, Live, Live)) == Live)
    }

    it("should kill any live cell with more than three live neighbours") {
      assert(RuleEngine.nextState(Live, List(Live, Live, Live, Live)) == Dead)
    }

    it("should revive any dead cell with exactly three live neighbours") {
      assert(RuleEngine.nextState(Dead, List(Live, Live, Live)) == Live)
    }

    it("should not revive any dead cell with exactly two live neighbours") {
      assert(RuleEngine.nextState(Dead, List(Live, Live)) == Dead)
    }
  }
}
