package musicle

import com.raquo.laminar.api.L.{ *, given }
import musicle.audio.{ AudioController, YoutubeEmbed }
import musicle.controls.SearchFieldControl
import musicle.game.{ Game, GameControl, GameType, SongLibrary, SongPicker }
import org.scalajs.dom

import java.time.*
import scala.collection.mutable

@main def hello(): Unit =
  // Laminar initialization
  renderOnDomContentLoaded(dom.document.querySelector("#app"), appElement())
  setGameDate(LocalDate.now())

// Game-dependencies
val websiteState: Var[WebsiteState]        = Persistence.getWebsiteState
val youtubeEmbed: YoutubeEmbed             = YoutubeEmbed()
val searchFieldControl: SearchFieldControl = SearchFieldControl()
val songLibrary: SongLibrary               = SongLibrary(SongLibrary.loadSongs())

// Game
val currentGame: Var[Game]   = Var(loadGameByDate(LocalDate.now()))
val gameControl: GameControl = GameControl(currentGame, youtubeEmbed, searchFieldControl)

// Other
val currentDate: Var[LocalDate] = Var(LocalDate.now())

def newGameByDate(date: LocalDate): Game =
  Game(SongPicker.DateSong(date, songLibrary), GameType.StandardGame, List())

def getOrInitializeGameByDate(date: LocalDate): Game =
  if websiteState.now().gameData.contains(date) then websiteState.now().gameData(date)
  else
    val newGame = newGameByDate(date)
    websiteState.update(_.updateGame(date, newGame))
    newGame

def loadGameByDate(date: LocalDate): Game =
  getOrInitializeGameByDate(date)

def saveCurrentGame(): Unit =
  websiteState.update(_.updateGame(currentDate.now(), currentGame.now()))

def setGameDate(date: LocalDate): Unit =
  saveCurrentGame()

  currentDate.set(date)
  currentGame.set(loadGameByDate(date))
  gameControl.reload()

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
      div(
        button("<-", onClick --> { _ => navigateGameDate(-1) }),
        button(
          "->",
          hidden <-- currentDate.signal.map(_ == LocalDate.now().plusDays(1)),
          onClick --> { _ => navigateGameDate(1) },
        ),
      ),
    ),
    footerTag(
      p("Created with <3 by Kresten"),
    ),
  )
