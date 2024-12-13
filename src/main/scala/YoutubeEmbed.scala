import Game.{ Game, Song }
import com.raquo.airstream.core.Transaction
import com.raquo.laminar.api.L.{ *, given }
import org.scalajs.dom
import org.scalajs.dom.html

object YoutubeEmbed:
  private val youtubeVideoSource: Var[String] = Var("VoGilr7ediw")
  private val youtubeStart: Var[Int]          = Var(0)
  private val youtubeEnd: Var[Int]            = Var(1)

  private def sendPostMessage(iframe: dom.HTMLIFrameElement, command: String): Unit =
    iframe.contentWindow.postMessage(command, "*")

  def component(song: Song, finished: Var[Boolean]): HtmlElement =
    youtubeVideoSource.set(song.sourcePath)

    iframe(
      idAttr := "ytplayer",
      hidden <-- finished.signal.map(f => !f),
      src <-- youtubeVideoSource.signal
        .combineWithFn(youtubeStart.signal, youtubeEnd.signal) { (videoSource, start, end) =>
          s"https://www.youtube-nocookie.com/embed/$videoSource?enablejsapi=1&start=$start&end=$end"
        },
    )

  def setSnippet(startMs: Int, endMs: Int) =
    // Transaction?
    youtubeStart.set(math.ceil(startMs / 1000).toInt)
    youtubeEnd.set(math.ceil(endMs / 1000).toInt)

  def play() =
    val iframe = dom.document.getElementById("ytplayer").asInstanceOf[dom.HTMLIFrameElement]
    sendPostMessage(iframe, """{ "event": "command", "func": "playVideo" }""")

  def pause() =
    val iframe = dom.document.getElementById("ytplayer").asInstanceOf[dom.HTMLIFrameElement]
    sendPostMessage(iframe, """{ "event": "command", "func": "pauseVideo" }""")
