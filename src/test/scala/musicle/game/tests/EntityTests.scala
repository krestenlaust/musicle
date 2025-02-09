package musicle.game.test

import musicle.game.*
import org.scalatest.flatspec.AnyFlatSpec
import io.bullet.borer.Json
import io.bullet.borer.syntax._

class EntityTests extends AnyFlatSpec {
  "Entity attributes" should "be accessible" in {
    val entity = Entity(
      EntityId("song_001"),
      EntityKind("music"),
      "title"     -> TitleAttribute("Runaway"),
      "artist"    -> ArtistAttribute("Aurora"),
      "album"     -> AlbumAttribute("All My Demons Greeting Me as a Friend"),
      "music_uri" -> YoutubeAttribute("BRpS93I8_Jk"),
    )

    val actualTitleAttribute = entity.getAttribute[TitleAttribute]("title")

    assert(actualTitleAttribute.isDefined === true)
    assert(actualTitleAttribute.get === TitleAttribute("Runaway"))
  }

  "Entity attributes" should "be parsed from JSON" in {
    val jsonString =
      """
            {
            "category": "music",
            "title": "Runaway",
            "artist": "Aurora",
            "music_uri": "https://youtube.com/...",
            "lyrics_sample": "I was listening to the ocean...",
            "release_year": 2015,
            "album": "All My Demons Greeting Me as a Friend"
            }
        """
    val decoder = Json.parse(jsonString).to[Entity]

    assert(decoder.isDefined === true)
    val entity = decoder.get

    val actualTitleAttribute = entity.getAttribute[TitleAttribute]("title")
    assert(actualTitleAttribute.isDefined === true)
    assert(actualTitleAttribute.get === TitleAttribute("Runaway"))
  }
}
