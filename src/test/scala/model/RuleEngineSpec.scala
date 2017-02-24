import model.{Dead, Live, RuleEngine}
import org.scalatest.FunSpec

class RuleEngineSpec extends FunSpec {

  describe("A RuleEngine") {

    it("should kill any lived cell with no live neighbour") {
      assert(RuleEngine.nextState(Live, List(Dead)) == Dead)
    }

    it("should kill any lived cell with one live neighbour") {
      assert(RuleEngine.nextState(Live, List(Live)) == Dead)
    }

  }
}
