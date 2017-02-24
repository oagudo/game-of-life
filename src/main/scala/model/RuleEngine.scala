package model

object RuleEngine {
  def nextState(c: Cell, neighbours: List[Cell]) : Cell = {
    val liveNeighbours = neighbours.count(_ == Live)

    c match {
      case Live => if (liveNeighbours < 2) Dead else Live
      case _ => Live
    }
  }
}
