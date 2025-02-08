package musicle.game

sealed trait EntityAttribute[T]:
    def value: T

abstract class StringAttribute(value: String) extends EntityAttribute[String]
abstract class IntegerAttribute(value: Int) extends EntityAttribute[Int]

case class TitleAttribute(value: String) extends StringAttribute(value)
case class ArtistAttribute(value: String) extends StringAttribute(value)
case class YoutubeAttribute(value: String) extends StringAttribute(value)
case class AlbumAttribute(value: String) extends StringAttribute(value)
case class ReleaseYearAttribute(value: Int) extends IntegerAttribute(value)
