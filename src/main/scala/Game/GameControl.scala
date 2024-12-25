package Game

import Audio.YoutubeEmbed
import Controls.SearchFieldControl
import com.raquo.laminar.api.L.{ *, given }
import Game.*
import _root_.Game.GameControl.guessesToGuessSlots

class GameControl(val game: Var[Game], youtubeEmbed: YoutubeEmbed):
  def component(): Seq[HtmlElement] =
    Seq(
      youtubeEmbed.component(),
      // h1(text <-- game.signal.map(currentGame => currentGame.date)),
      div(
        child <-- game.signal.map(currentGame =>
          ul(
            cls := "guess-container",
            children <-- currentGame.guesses.signal.map(guessList =>
              guessesToGuessSlots(currentGame, guessList).map(guess => li(guessElement(guess))),
            ),
          ),
        ),
      ),
      // progressBar(),
      skipButton(),
      playButton(),
      SearchFieldControl.component(game.now().songs, game.now().isGuessed, songListElement),
    )

  def reload(): Unit =
    val currentGame: Game = game.now()

    // Always hide embed, otherwise it will flash the answer.
    youtubeEmbed.videoHidden.set(true)
    currentGame.loadStage()

  private def guessSong(song: Option[Song]): Unit =
    val currentGame = game.now()

    // Guess
    val correct = song match {
      case Some(s) => currentGame.guessStage(s)
      case None =>
        currentGame.skipStage()
        false
    }

    // Post-guess
    youtubeEmbed.videoHidden.set(!(correct || currentGame.currentStage() == currentGame.maxGuesses))

    currentGame.loadStage()
    if correct then currentGame.playFullSong()

    currentGame.playCurrentStage()

  private def skipButton(): HtmlElement =
    button(
      "Skip",
      cls := "grey-button",
      onClick --> { _ => guessSong(None) },
    )

  private def playButton(): HtmlElement =
    button("Play", onClick --> { _ => game.now().playCurrentStage() })

  private def guessElement(guessSlot: GuessSlot): HtmlElement =
    div(
      cls := s"guess-row guess-box ${if guessSlot.correct then " correct-guess" else ""}",
      guessSlot.song match {
        case Some(s) =>
          Seq(
            span(cls := "guess-title", s.title),
            span(cls := "guess-album", s.album.toString),
          )
        case None =>
          if guessSlot.skipped then Seq(span(cls := "guess-title", "- Skipped -"))
          else Seq(span())
      },
    )

  private def songListElement(song: Song): HtmlElement =
    li(cls := "song", p(song.toString), onClick --> { _ => guessSong(Some(song)) })

object GameControl:
  def guessesToGuessSlots(game: Game, guesses: List[Guess]): List[GuessSlot] =
    guesses
      .map(guess => GuessSlot(guess.song, guess.song.isEmpty, guess.song.getOrElse(false) == game.actualSong))
      .padTo(game.maxGuesses, GuessSlot(None, false, false))

case class GuessSlot(song: Option[Song], skipped: Boolean, correct: Boolean)
