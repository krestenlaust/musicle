package musicle.game

import Game.*

case class Entity(id: ObjectId, kind: EntityKind, attributes: Map[String, EntityAttribute[?]]):
  override def toString: String = s"$kind - $id"

  def getAttribute[T <: EntityAttribute[?]](key: String): Option[T] =
    attributes.get(key).map(_.asInstanceOf[T])

object Entity:
  def apply(id: ObjectId, kind: EntityKind, attributes: (String, EntityAttribute[?])*): Entity =
    new Entity(id, kind, attributes.toMap)
