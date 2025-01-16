package musicle.controls

import com.raquo.laminar.api.L.{ *, given }
import musicle.utils.SearchUtil
import org.scalajs.dom

class SearchFieldControl:
  def component[A](
      database: Seq[A],
      exclusionFilter: A => Boolean,
      renderListItem: A => HtmlElement,
      handleListItemClick: A => Unit,
  ): HtmlElement =
    val searchQueryVar = Var("")

    div(
      cls := "container",
      input(
        cls         := List("guess-input", "guess-box"),
        typ         := "text",
        placeholder := "Runaway...",
        value <-- searchQueryVar.signal,
        inContext { thisNode =>
          onInput.mapTo(thisNode.ref.value) --> searchQueryVar
        },
      ),
      ul(
        cls := "searched-songs",
        children <-- searchQueryVar.signal.map { query =>
          query.trim match {
            case "" => Seq.empty
            case _ =>
              SearchUtil
                .search(database, query, exclusionFilter)
                .take(7)
                .map(item =>
                  li(
                    cls := "song",
                    renderListItem(item),
                    onClick --> { _ =>
                      handleListItemClick(item)
                      searchQueryVar.set("")
                    },
                  ),
                )
          }
        },
      ),
    )
