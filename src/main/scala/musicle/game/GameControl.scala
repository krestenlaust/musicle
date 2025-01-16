package musicle.game

import com.raquo.laminar.api.L.{ *, given }
import Game.*
import GameControl.guessesToGuessSlots
import musicle.audio.YoutubeEmbed
import musicle.controls.SearchFieldControl

class GameControl(val game: Var[Game], youtubeEmbed: YoutubeEmbed, searchField: SearchFieldControl):
  def component(): Seq[HtmlElement] =
    Seq(
      youtubeEmbed.component(),
      // h1(text <-- game.signal.map(currentGame => currentGame.date)),
      div(
        ul(
          cls := "guess-container",
          children <-- game.signal.map(currentGame =>
            guessesToGuessSlots(currentGame, currentGame.guesses).map(guess => li(guessElement(guess))),
          ),
        ),
      ),
      searchField.component(
        game.now().gameType.songs,
        game.now().isGuessed,
        songListElement,
        songListElementClickHandler,
      ),
      // progressBar(),
      skipButton(),
      playButton(),
    )

  def reload(): Unit =
    // Always hide embed, otherwise it will flash the answer.
    youtubeEmbed.videoHidden.set(true)
    youtubeEmbed.loadCurrentStage(game.now())

  private def songListElement(song: Song): HtmlElement = p(song.toString)

  private def songListElementClickHandler(song: Song): Unit = guessSong(Some(song))

  private def guessSong(song: Option[Song]): Unit =
    // Guess
    song match {
      case Some(s) => game.update(_.guessStage(s))
      case None    => game.update(_.skipStage())
    }

    // Post-guess
    youtubeEmbed.videoHidden.set(!(game.now().finished))

    youtubeEmbed.loadCurrentStage(game.now())
    if game.now().finished then youtubeEmbed.loadFullSong(game.now())

    youtubeEmbed.play()

  private def skipButton(): HtmlElement =
    button(
      "Skip",
      cls := "grey-button",
      onClick --> { _ => guessSong(None) },
    )

  private def playButton(): HtmlElement =
    button("Play", onClick --> { _ => youtubeEmbed.play() })

  private def guessElement(guessSlot: GuessSlot): HtmlElement =
    div(
      cls := s"guess-row guess-box guess-${if guessSlot.correct then "correct" else "wrong"}",
      guessSlot.song match {
        case Some(s) =>
          Seq(
            span(cls := "guess-title", s.title),
            span(
              cls := s"guess-album guess-album-${if guessSlot.correct_album then "correct" else "wrong"}",
              s.album.toString,
            ),
          )
        case None =>
          if guessSlot.skipped then Seq(span(cls := "guess-title", "- Skipped -"))
          else Seq(span())
      },
    )

object GameControl:
  def guessesToGuessSlots(game: Game, guesses: List[Guess]): List[GuessSlot] =
    guesses
      .map(guess =>
        GuessSlot(
          guess.song,
          guess.song.isEmpty,
          guess.song.contains(game.actualSong),
          guess.song.exists(_.album == game.actualSong.album),
        ),
      )
      .padTo(game.gameType.maxGuesses, GuessSlot(None, false, false, false))

case class GuessSlot(song: Option[Song], skipped: Boolean, correct: Boolean, correct_album: Boolean)
