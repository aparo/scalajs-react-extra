
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object PageItem /* mixins: */ {

  case class State()

  class Backend(t: BackendScope[Props, State]) {
    def handleSelect(event: ReactEventI): Unit = {
      if (t.props.onSelect!=null)
      {
        event.preventDefault()
        if (!t.props.disabled)
        {
          t.props.onSelect(t.props.eventKey, t.props.href, t.props.target)
        }
      }
    }
  }

  val component = ReactComponentB[Props]("PageItem")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    val classes = Map("disabled" -> P.disabled, "previous" -> P.previous, "next" -> P.next)

    <.li(^.classSet1M(P.className, classes),
      <.a(^.href := P.href, ^.title := P.title, ^.target := P.target, ^.onClick ==> B.handleSelect, ^.ref := "anchor", C))
  }
    )
    .build

 case class Props(title: String = "", className: String = "", disabled: Boolean = false, eventKey: Any = null, href: String = "#",
                    next: Boolean = false, onSelect: (Any, String, String) => Unit = null, previous: Boolean = false,
                    target: String = "")

  def apply(title: String = "", className: String = "", disabled: Boolean = false, eventKey: Any = null, href: String = "#",
            next: Boolean = false, onSelect: (Any, String, String) => Unit = null, previous: Boolean = false,
            target: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(title = title, className = className, disabled = disabled, eventKey = eventKey, href = href,
      next = next, onSelect = onSelect, previous = previous,
      target = target), children)
  }

}
