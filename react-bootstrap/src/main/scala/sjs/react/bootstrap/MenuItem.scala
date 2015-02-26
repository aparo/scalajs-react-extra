
package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object MenuItem /* mixins: */ {

  case class State()

  class Backend(t: BackendScope[Props, State]) {
    def handleClick(event: ReactEvent): Unit = {
      if (t.props.onSelect != null) {
        event.preventDefault()
        t.props.onSelect(t.props.eventKey, t.props.href, t.props.target)
      }
    }

  }

  val component = ReactComponentB[Props]("MenuItem")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    val classes = Map("dropdown-header" -> P.header, "divider" -> P.divider)
    var children:TagMod = null
    if (P.header) {
      children = C
    } else if (!P.divider) {
      children = <.a(^.onClick ==> B.handleClick, ^.href := P.href, ^.target := P.target, ^.title := P.title, ^.tabIndex := "-1", C)
    }

    <.li(^.role := "presentation", ^.title := "", ^.href := "", ^.classSet1M(P.className, classes), children)
  }
    )
    .build

  case class Props(className: String = "", divider: Boolean = false, eventKey: Any = null, header: Boolean = false,
                   href: String = "#", onSelect: (Any, String, String) => Unit = null, target: String = "",
                   title: String = "")

  def apply(className: String = "", divider: Boolean = false, eventKey: Any = null, header: Boolean = false,
            href: String = "#", onSelect: (Any, String, String) => Unit = null, target: String = "",
            title: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, divider = divider, eventKey = eventKey, header = header,
      href = href, onSelect = onSelect, target = target,
      title = title), children)
  }

}
