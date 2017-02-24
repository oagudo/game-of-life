import model.RuleEngine
import org.scalatest.FunSpec

class RuleEngineSpec extends FunSpec {

  describe("A RuleEngine") {

    it("should kill any lived cell with less than two live neighbours") {
      assert(RuleEngine.nextState(Live, List(Live)) == Dead)
    }

  }
}
