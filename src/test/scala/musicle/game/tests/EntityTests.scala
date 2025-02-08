package musicle.game.test

import musicle.game.*
import org.scalatest.flatspec.AnyFlatSpec

class EntityTests extends AnyFlatSpec {
  "Entity attributes" should "be accessible" in {
    val entity = Entity(
        EntityId("song_001"),
        EntityCategory("music"),
        "title" -> TitleAttribute("Runaway"),
        "artist" -> ArtistAttribute("Aurora"),
        "album" -> AlbumAttribute("All My Demons Greeting Me as a Friend"),
        "music_uri" -> YoutubeAttribute("BRpS93I8_Jk"),
        )

    val actualTitleAttribute = entity.getAttribute[TitleAttribute]("title")
    
    assert(actualTitleAttribute.isDefined === true)
    assert(actualTitleAttribute.get === TitleAttribute("Runaway"))
  }
}
