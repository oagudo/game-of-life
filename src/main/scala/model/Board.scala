package model

case class Position(x : Int, y : Int)

class Board(val dimension : Int) {

  private val cells = Array.ofDim[Cell](dimension, dimension)

  val positions = for {
    x <- 0 until dimension
    y <- 0 until dimension
  } yield Position(x, y)

  positions.foreach(setCell(Dead, _))

  def setCell(c : Cell, p : Position): Unit = {
    cells(p.x)(p.y) = c
  }

  def getCell(p : Position): Cell = {
    return cells(p.x)(p.y)
  }
}