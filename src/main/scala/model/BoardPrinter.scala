package model

object BoardPrinter {
  def print(b : Board): Unit = {
    for(x <- 0 until b.dimension){
      for(y <- 0 until b.dimension){
        val c = b.getCell(Position(x, y))
        printf(if (c == Live) "X" else "  ")
      }
      println()
    }
  }
}