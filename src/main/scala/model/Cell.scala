package model

sealed trait Cell
final case object Live extends Cell
final case object Dead extends Cell