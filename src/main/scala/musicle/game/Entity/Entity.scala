package musicle.game

import Game.*

case class Entity(id: EntityId, category: EntityCategory, attributes: Map[String, EntityAttribute[?]]):
  override def toString: String = s"$category - $id"

  def getAttribute[T <: EntityAttribute[?]](key: String): Option[T] =
    attributes.get(key).map(_.asInstanceOf[T])

object Entity:
  def apply(id: EntityId, category: EntityCategory, attributes: (String, EntityAttribute[?])*): Entity =
    new Entity(id, category, attributes.toMap)
