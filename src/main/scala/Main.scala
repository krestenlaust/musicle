import Audio.{ AudioController, YoutubeEmbed }
import com.raquo.laminar.api.L.{ *, given }
import org.scalajs.dom
import Game.*

import java.time.*
import scala.collection.mutable

@main def hello(): Unit =
  // Laminar initialization
  renderOnDomContentLoaded(dom.document.querySelector("#app"), appElement())
  setGameDate(LocalDate.now())

// Game-dependencies
val gameByDate: mutable.Map[LocalDate, Game] = scala.collection.mutable.Map()
val youtubeEmbed: YoutubeEmbed               = YoutubeEmbed()
val songLibrary: SongLibrary                 = SongLibrary(SongLibrary.loadSongs())

// Game
val game: Var[Game]          = Var(loadGameByDate(LocalDate.now()))
val gameControl: GameControl = GameControl(game, youtubeEmbed)

// Other
val currentDate: Var[LocalDate] = Var(LocalDate.now())

def loadGameByDate(date: LocalDate): Game =
  gameByDate.getOrElseUpdate(
    date,
    Game(SongPicker.TodaySong(songLibrary), songLibrary.songs, youtubeEmbed),
  )

def setGameDate(date: LocalDate): Unit =
  currentDate.set(date)
  game.set(loadGameByDate(date))
  gameControl.reload()
  dom.console.log(gameByDate)

def navigateGameDate(daysOffset: Int): Unit =
  setGameDate(currentDate.now().plusDays(daysOffset))

def appElement(): HtmlElement =
  div(
    headerTag(
      h1("AURORDLE"),
      h3(
        text <-- currentDate.signal.map(date =>
          if date == LocalDate.now() then "Today"
          else if date == LocalDate.now().minusDays(1) then "Yesterday"
          else if date == LocalDate.now().plusDays(1) then "Tomorrow"
          else date.toString,
        ),
      ),
    ),
    mainTag(
      gameControl.component(),
      button("<-", onClick --> { _ => navigateGameDate(-1) }),
      button("->", onClick --> { _ => navigateGameDate(1) }),
    ),
    footerTag(
      p("Created with <3 by Kresten"),
    ),
  )
