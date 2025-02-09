import io.bullet.borer.derivation.MapBasedCodecs.*
import io.bullet.borer.{ Codec, Decoder, Encoder }
import musicle.game.*

given titleAttributeCodec: Codec[TitleAttribute]        = deriveCodec
given artistAttributeCodec: Codec[ArtistAttribute]      = deriveCodec
given youtubeAttributeCodec: Codec[YoutubeAttribute]    = deriveCodec
given albumAttributeCodec: Codec[AlbumAttribute]        = deriveCodec
given releaseYearAttribute: Codec[ReleaseYearAttribute] = deriveCodec

given entityKindCodec: Codec[EntityKind] = deriveCodec
given entityIdCodec: Codec[EntityId]     = deriveCodec
given entityCodec: Codec[Entity]         = deriveCodec
