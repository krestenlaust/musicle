package Game

case class SongLibrary(songs: List[Song])

object SongLibrary:
  def loadSongs(): List[Song] =
    List(
      // Singles in other's albums
      Song("Thank U", 0, Album("Goodnight Songs For Rebel Girls"), Author("AURORA"), "E39j5Mg7X-0"),

      // Singles
      Song("Hunting Shadows (Assassin's Creed)", 1500, Album("Single"), Author("AURORA"), "cdp17rFzH3U"),
      Song("The Secret Garden", 0, Album("Single"), Author("AURORA"), "rxaRoYCi2vo"),
      Song("Midas Touch", 0, Album("Single"), Author("AURORA"), "cGqC8AL01Og"),
      Song("The Devil Is Human", 0, Album("Single"), Author("AURORA"), "hWjiSEJTMOQ"),
      Song("A Potion For Love", 0, Album("Single"), Author("AURORA"), "JfCr8ktyHw4"),
      Song("Under Stars", 0, Album("Single"), Author("AURORA"), "_7o-rRC-3hs"),

      // Running With The Wolves (EP)
      Song("Runaway", 0, Album("Running With The Wolves (EP)"), Author("AURORA"), "BRpS93I8_Jk"),
      Song("Running With The Wolves", 250, Album("Running With The Wolves (EP)"), Author("AURORA"), "2M94IMhk6o0"),
      Song("In Boxes", 2000, Album("Running with the Wolves (EP)"), Author("AURORA"), "blRQ8GUcNJ0"),
      Song("Little Boy In The Grass", 500, Album("Running with the Wolves (EP)"), Author("AURORA"), "2MTsfnntwWc"),

      // All My Demons Greeting Me As A Friend
      // - Runaway
      Song("Conqueror", 0, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "VsrRDKENb3w"),
      // - Running With The Wolves
      Song("Lucky", 2000, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "W7IzaZ1716M"),
      Song("Winter Bird", 1500, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "d3O8XiPQO_s"),
      Song("I Went Too Far", 0, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "-Z9lAvNgySU"),
      Song("Through The Eyes Of A Child", 6000, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "M0O8Ih1tv1A"),
      Song("Warrior", 0, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "Zkc7z7hvxi4"),
      Song("Murder Song (5, 4, 3, 2, 1)", 0, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "xFXEbsP6iyI"),
      Song("Home", 0, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "eAIt4N9MtmM"),
      Song("Under The Water", 500, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "qtau-YHnEeY"),
      Song("Black Water Lilies", 0, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "qP5deqLuH8o"),
      Song("Half The World Away", 0, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "bIVpB92hWIg"),
      // Deluxe Edition (without variants)
      Song("Wisdom Cries", 8000, Album("All My Demons Greeting Me As A Friend"), Author("AURORA"), "q0r36IrK5P8"),

      // The Gods We Can Touch
      Song("The Forbidden Fruits of Eden", 1000, Album("The Gods We Can Touch"), Author("AURORA"), "wItPEYN5aJw"),
      Song("Everything Matters (Feat. Pomme)", 0, Album("The Gods We Can Touch"), Author("AURORA"), "oa7JwwdiA98"),
      Song("Giving In to the Love", 0, Album("The Gods We Can Touch"), Author("AURORA"), "mcTszeIl-SE"),
      Song("Cure For Me", 0, Album("The Gods We Can Touch"), Author("AURORA"), "VoGilr7ediw"),
      Song("Exist For Love", 0, Album("The Gods We Can Touch"), Author("AURORA"), "rAMX3yk5voI"),
      Song("You Keep Me Crawling", 0, Album("The Gods We Can Touch"), Author("AURORA"), "p3AMcbXX4O0"),
      Song("Heathens", 0, Album("The Gods We Can Touch"), Author("AURORA"), "U36rDsd6ARs"),
      Song("The Innocent", 0, Album("The Gods We Can Touch"), Author("AURORA"), "5eoqQBJOw4A"),
      Song("Exhale Inhale", 0, Album("The Gods We Can Touch"), Author("AURORA"), "5jICJdWnH6o"),
      Song("A Temporary High", 3000, Album("The Gods We Can Touch"), Author("AURORA"), "7_4JqVAK5WE"),
      Song("A Dangerous Thing", 0, Album("The Gods We Can Touch"), Author("AURORA"), "6KmWlzUz_54"),
      Song("Artemis", 1000, Album("The Gods We Can Touch"), Author("AURORA"), "qpx1wwlQf3U"),
      Song("Blood In the Wine", 0, Album("The Gods We Can Touch"), Author("AURORA"), "sKSupqVcVJw"),
      Song("This Could Be a Dream", 500, Album("The Gods We Can Touch"), Author("AURORA"), "DbiB1AtCA9k"),
      Song("A Little Place Called the Moon", 500, Album("The Gods We Can Touch"), Author("AURORA"), "QdLNfkFWF0g"),

      // Infection Of A Different Kind – Step 1
      Song("Queendom", 1000, Album("Infection Of A Different Kind – Step 1"), Author("AURORA"), "-PIC0wb8jgY"),
      Song("Forgotten Love", 0, Album("Infection Of A Different Kind – Step 1"), Author("AURORA"), "Pm0GiTTAXUc"),
      Song("Gentle Earthquakes", 0, Album("Infection Of A Different Kind – Step 1"), Author("AURORA"), "El_N-2V9iv8"),
      Song("All Is Soft Inside", 0, Album("Infection Of A Different Kind – Step 1"), Author("AURORA"), "CRbrZtR8DOg"),
      Song("It Happened Quiet", 500, Album("Infection Of A Different Kind – Step 1"), Author("AURORA"), "2wd7hOSPPP0"),
      Song("Churchyard", 250, Album("Infection Of A Different Kind – Step 1"), Author("AURORA"), "KOhjQvUI3Qo"),
      Song("Soft Universe", 750, Album("Infection Of A Different Kind – Step 1"), Author("AURORA"), "daHIgxDSLMY"),
      Song("Infections Of A Different Kind", 2000, Album("Infection Of A Different Kind – Step 1"), Author("AURORA"), "7EmdiaUX-wI"),

      // A Different Kind Of Human – Step 2
      Song("The River", 3000, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "pz5FzFL2L7w"),
      Song("Animal", 0, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "eMM1FC3Tbe0"),
      Song("Dance On The Moon", 0, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "2GPh59K8_ys"),
      Song("Daydreamer", 0, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "soCJTCElcbk"),
      Song("Hunger", 250, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "TgAjyR3_2yM"),
      Song("Soulless Creatures", 0, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "EiWUBdyDk70"),
      Song("In Bottles", 250, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "1okNR0Dzyv8"),
      Song("A Different Kind Of Human", 1000, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "WuPh0Ozd4EE"),
      Song("Apple Tree", 0, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "fgjId8R5RL8"),
      Song("The Seed", 750, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "JJTjc7iRNY8"),
      Song("Mothership", 500, Album("A Different Kind Of Human – Step 2"), Author("AURORA"), "IP1Qhq8kQBY"),

      // What Happened To The Heart?
      Song("Echo Of My Shadow", 4000, Album("What Happended To The Heart?"), Author("AURORA"), "kkPYHeSU_y4"),
      Song("To Be Alright", 0, Album("What Happended To The Heart?"), Author("AURORA"), "kcSfjgyP6Bg"),
      Song("Your Blood", 0, Album("What Happended To The Heart?"), Author("AURORA"), "89GvgJ0Rn54"),
      Song("The Conflict Of The Mind", 2500, Album("What Happended To The Heart?"), Author("AURORA"), "XO2tAfUe2HU"),
      Song("Some Type Of Skin", 1000, Album("What Happended To The Heart?"), Author("AURORA"), "b1pMORnf0Hs"),
      Song("The Essence", 250, Album("What Happended To The Heart?"), Author("AURORA"), "iwthrbcxLFs"),
      Song("Earthly Delights", 0, Album("What Happended To The Heart?"), Author("AURORA"), "BbuJh-DtI2o"),
      Song("When The Dark Dresses Lightly", 0, Album("What Happended To The Heart?"), Author("AURORA"), "jqstwM5dN90"),
      Song("A Soul With No King", 0, Album("What Happended To The Heart?"), Author("AURORA"), "xulbh2x7MKE"),
      Song("Dreams", 0, Album("What Happended To The Heart?"), Author("AURORA"), "g1js5rl4n1g"),
      Song("My Name (feat. Ane Brun)", 0, Album("What Happended To The Heart?"), Author("AURORA"), "cFigdwdinY0"),
      Song("Do You Feel?", 0, Album("What Happended To The Heart?"), Author("AURORA"), "JVZJmJIBc3E"),
      Song("Starvation", 0, Album("What Happended To The Heart?"), Author("AURORA"), "aCpLcXLiYDo"),
      Song("The Blade", 0, Album("What Happended To The Heart?"), Author("AURORA"), "mjvPT3jJhLs"),
      Song("My Body Is Not Mine", 500, Album("What Happended To The Heart?"), Author("AURORA"), "9W9B5-J0ZKI"),
      Song("Invisible Wounds", 0, Album("What Happended To The Heart?"), Author("AURORA"), "CHP8SVE4yCQ"),
    )
