
package sjs.react.bootstrap

import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object ListGroupItem /* mixins: BootstrapMixin*/ {

  case class State()

  class Backend(t: BackendScope[Props, State]) {
    def handleClick(event: ReactEvent) {
      if (t.props.onClick != null) {
        event.preventDefault()
        t.props.onClick(t.props.eventKey, t.props.href, t.props.target)
      }
    }
  }

  val component = ReactComponentB[Props]("ListGroupItem")
    .initialState(State())
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {

        def renderStructuredContent:Seq[TagMod] = {
          val content = <.p(^.className := "list-group-item-text", C)
          if (React.isValidElement(P.header)) {
            List(ReactCloneWithProps(P.header, Map("class" -> "list-group-item-heading")))
          } else {
            List(<.h4(^.className := "list-group-item-heading", P.header), content)
          }
        }


        def renderAnchor(classes: Map[String, Boolean]) = {
          <.a(^.classSet1M(P.className, classes), ^.onClick ==> B.handleClick, if (P.header != null) renderStructuredContent else C)
        }

        def renderSpan(classes: Map[String, Boolean]) = {
          <.span(^.classSet1M(P.className, classes), if (P.header != null) renderStructuredContent else C)
        }


        var classes = P.getBsClassSet
        classes += ("active" -> P.active)
        classes += ("disabled" -> P.disabled)
        if (P.href.nonEmpty || P.target.nonEmpty || P.onClick != null) {
          renderAnchor(classes)
        } else {
          renderSpan(classes)
        }
      }


    )
    .build

  case class Props(className: String = "", bsStyle: String = "", active: Boolean = false, bsClass: String = "list-group-item",
                   bsSize: String = "", disabled: Boolean = false, eventKey: Any = null,
                   header: ReactElement = null, href: String = "", onClick: (Any, String, String) => Unit = null,
                   target: String = "") extends BoostrapMixinProps

  def apply(className: String = "", bsStyle: String = "", active: Boolean = false, bsClass: String = "list-group-item",
            bsSize: String = "", disabled: Boolean = false, eventKey: Any = null,
            header: ReactElement = null, href: String = "", onClick: (Any, String, String) => Unit = null,
            target: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bsStyle = bsStyle, active = active, bsClass = bsClass,
      bsSize = bsSize, disabled = disabled, eventKey = eventKey,
      header = header, href = href, onClick = onClick,
      target = target), children)
  }

}
