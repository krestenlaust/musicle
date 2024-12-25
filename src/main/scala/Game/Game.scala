package Game

import Audio.AudioController
import com.raquo.laminar.api.L.Var

class Game(val actualSong: Song, val songs: List[Song], audioController: AudioController):
  val maxGuesses                = 5
  val guesses: Var[List[Guess]] = Var(List())
  private val stageSprites: List[Int] = List(
    1000, 2000, 4000, 8000, 16000,
  )

  def finished(): Boolean =
    guesses.now().lastOption match {
      case Some(lst) => lst.song.getOrElse(false) == actualSong
      case None      => false
    }

  def loadStage(): Unit =
    audioController.setSong(actualSong.sourcePath)
    audioController.setSnippet(actualSong.startOffset, actualSong.startOffset + stageSprites(currentStage()))

  def playCurrentStage(): Unit =
    audioController.play()

  def playFullSong(): Unit =
    audioController.setSnippet(0, 500_000)

  def currentStage(): Int = guesses.now().length

  def isGuessed(guessedSong: Song): Boolean =
    guesses.now().contains(guessedSong)

  def guessStage(guessedSong: Song): Boolean =
    guesses.update(lst => lst :+ Guess(Some(guessedSong)))

    actualSong == guessedSong

  def skipStage(): Unit =
    guesses.update(lst => lst :+ Guess(None))

case class Guess(song: Option[Song])
