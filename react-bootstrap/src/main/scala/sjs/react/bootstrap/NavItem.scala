
package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.LogLifecycle
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object NavItem /* mixins: BootstrapMixin*/ {

  case class State()

  class Backend(t: BackendScope[Props, State]) {
    def handleClick(event: ReactEvent): Unit = {
      if (t.props.onSelect != null) {
        event.preventDefault()
        if (!t.props.disabled) {
          t.props.onSelect(t.props.eventKey, t.props.href, t.props.target)
        }
      }
    }

  }

  val component = ReactComponentB[Props]("NavItem")
    .initialState(State())
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {
        val classes = Map(
          "active" -> P.active,
          "disabled" -> P.disabled
        )


        <.li(/* {...props}*/^.cls := P.className, ^.classSetM(classes),
          <.a(
            ^.href := P.href,
            ^.title := P.title,
            ^.target := P.target,
            ^.onClick ==> B.handleClick,
            ^.ref := "anchor",
            C
          )
        )
      }
    )
//    .configure(LogLifecycle.verbose)
    .build

  case class Props(active: Boolean = false, className: js.UndefOr[String]=js.undefined, bsClass: String = "", bsSize: String = "",
                   bsStyle: String = "", disabled: Boolean = false, eventKey: Any = null,
                   href: String = "#", onSelect: (Any, js.UndefOr[String], js.UndefOr[String]) => Unit = null, target: js.UndefOr[String]=js.undefined,
                   title: js.UndefOr[String]=js.undefined) extends BoostrapMixinProps

  def apply(active: Boolean = false, className: js.UndefOr[String]=js.undefined, bsClass: String = "", bsSize: String = "",
            bsStyle: String = "", disabled: Boolean = false, eventKey: Any = null,
            href: String = "#", onSelect: (Any, js.UndefOr[String], js.UndefOr[String]) => Unit = null, target: js.UndefOr[String]=js.undefined,
            title: js.UndefOr[String]=js.undefined, ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) =
    component.set(key, ref)(Props(active = active, className = className, bsClass = bsClass, bsSize = bsSize,
      bsStyle = bsStyle, disabled = disabled, eventKey = eventKey,
      href = href, onSelect = onSelect, target = target,
      title = title), children)


}
