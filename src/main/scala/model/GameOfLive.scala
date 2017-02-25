package model

case class GameOfLive(b : Board) {

  def tick() : GameOfLive = {
    val newBoard = new Board(b.dimension)

    b.positions.foreach(
      p => {
        val currentCell = b.getCell(p)
        val newCell = RuleEngine.nextState(currentCell, getNeighbours(p))
        newBoard.setCell(newCell, p)
      }
    )

    GameOfLive(newBoard)
  }

  def print() { BoardPrinter.print(b) }

  private def getNeighbours(p : Position) : List[Cell] = {
    val startX = if (p.x == 0) p.x else p.x - 1
    val startY = if (p.y == 0) p.y else p.y - 1
    val endX = if (p.x == b.dimension - 1) p.x else p.x + 1
    val endY = if (p.y == b.dimension - 1) p.y else p.y + 1

    val neighboursPos = for {
      x <- startX to endX
      y <- startY to endY
      if p != Position(x, y)
    } yield Position(x, y)

    neighboursPos.map(p => b.getCell(p)).toList

  }
}