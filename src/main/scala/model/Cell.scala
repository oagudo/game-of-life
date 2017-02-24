package model

sealed trait Cell
case object Live extends Cell
case object Dead extends Cell