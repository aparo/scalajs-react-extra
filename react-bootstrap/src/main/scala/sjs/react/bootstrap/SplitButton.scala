
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object SplitButton /* mixins: BootstrapMixin with DropdownStateMixin*/ {

  case class State(open: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {
    def handleDropdownClick(event: ReactEvent): Unit = {
      event.preventDefault()
      //      this.setDropdownState(!this.state.open)
      t.modState(s => s.copy(open = !s.open))
    }

    def handleButtonClick(event: ReactEvent): Unit = {
      if (t.state.open) {
        t.modState(s => s.copy(open = !s.open))
      }
      if (t.props.onClick != null) {
        t.props.onClick(event, t.props.href, t.props.target)
      }
    }

    def handleOptionSelect(event: ReactEvent): Unit = {
      if (t.props.onSelect != null) {
        t.props.onSelect(event)
      }
      t.modState(s => s.copy(open = false))
    }
  }

  val component = ReactComponentB[Props]("SplitButton")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    val groupClasses = Map("open" -> S.open, "dropup" -> P.dropup)
    val button = Button(ref = "button", onClick = B.handleDropdownClick, title = "" /*, id= null*/)(P.title)
    val dropdownButton = Button(ref = "dropdownButton", className = BootStrapFunctionUtils.joinClasses(P.className, "dropdown-toggle"),
      onClick = B.handleDropdownClick)(<.span(^.className := "sr-only", P.dropdownTitle),
        <.span(^.className := "caret"))
    ButtonGroup(bsSize = P.bsSize, className = groupClasses.filter(_._2).map(_._1).mkString("") /*, id= P.id}*/)(button, dropdownButton,
      DropdownMenu(ref = "menu", onSelect = B.handleOptionSelect, /*"aria-labelledby"= P.id,*/ pullRight = P.pullRight)(C))
  }
    )
    .build


  case class Props(dropup: Boolean = false, className: String = "", bsClass: String = "", bsSize: String = "", bsStyle: String = "",
                   disabled: Boolean = false, dropdownTitle: ReactElement = <.span("Toggle dropdown"), href: String = "",
                   onClick: (ReactEvent, String, String) => Unit = null, onSelect: (ReactEvent) => Unit = null, pullRight: Boolean = false,
                   target: String = "", title: ReactElement = null) extends BoostrapMixinProps

  def apply(dropup: Boolean = false, className: String = "", bsClass: String = "", bsSize: String = "", bsStyle: String = "",
            disabled: Boolean = false, dropdownTitle: ReactElement = <.span("Toggle dropdown"), href: String = "",
            onClick: (ReactEvent, String, String) => Unit = null, onSelect: (ReactEvent) => Unit = null, pullRight: Boolean = false,
            target: String = "", title: ReactElement = null, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, dropup = dropup, bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle,
      disabled = disabled, dropdownTitle = dropdownTitle, href = href,
      onClick = onClick, onSelect = onSelect, pullRight = pullRight,
      target = target, title = title), children)
  }

}
