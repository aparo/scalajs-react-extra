
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object DropdownButton /* mixins: BootstrapMixin with DropdownStateMixin*/ {

  case class State(open: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {
    def handleDropdownClick(event: ReactEvent): Unit = {
      event.preventDefault()
      //      this.setDropdownState(!this.state.open)
      t.modState(s => s.copy(open = !s.open))
    }

    def handleOptionSelect(event: ReactEvent): Unit = {
      if (t.props.onSelect != null) {
        t.props.onSelect(event)
      }
      //      this.setDropdownState(false)
      t.modState(s => s.copy(open = false))
    }
  }

  val component = ReactComponentB[Props]("DropdownButton")
    .initialState(State())
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {
        def renderNavItem(children: Seq[ReactNode]):ReactElement = {
          val classes = Map("dropdown" -> true, "open" -> S.open, "dropup" -> P.dropup)
          <.li(^.classSet1M(P.className, classes), children)
        }


        def renderButtonGroup(children: Seq[ReactNode]):ReactElement = {
          val groupClasses = Map("open" -> S.open, "dropup" -> P.dropup)
          ButtonGroup(bsSize = P.bsSize, className = BootStrapFunctionUtils.joinClasses(P.className, groupClasses))(children)
        }

        def renderMenuItem(child: ReactNode, index: Int): ReactElement = {
          val dchild = child.asInstanceOf[js.Dynamic]
          val key: Any = if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
          val handleOptionSelect: (ReactEvent) => Unit = if (P.onSelect != null || dchild.props.onSelect != null) B.handleOptionSelect else null
          val props: Map[String, Any] = Map(
            "onSelect" -> BootStrapFunctionUtils.createChainedFunction(child.asInstanceOf[js.Dynamic].props.onSelect.asInstanceOf[(ReactEvent) => Unit], handleOptionSelect),
            "key" -> key,
            "ref" -> child.asInstanceOf[js.Dynamic].ref
          )
          ReactCloneWithProps(child, props.asInstanceOf[Map[String, js.Any]])
        }



        val caret = if (P.noCaret) null else <.span(^.cls := "caret")
        val children = List(Button(ref = "dropdownButton", className = "dropdown-toggle", onClick = B.handleDropdownClick, key = 0,
          navDropdown = P.navItem, navItem = false, title = null, pullRight = false, dropup = false)(P.title, " ", caret),
          DropdownMenu(ref = "menu", /*"aria-labelledby" = P.id, */ pullRight = P.pullRight, key = 1)(ValidComponentChildren.map(C, renderMenuItem)))
        if (P.navItem) {
          renderNavItem(children)
        } else
          renderButtonGroup(children)
      }
    )
    .build

  case class Props(className: String = "", bsClass: String = "", bsSize: String = "", bsStyle: String = "",
                   dropup: Boolean = false, href: String = "", navItem: Boolean = false,
                   noCaret: Boolean = false, onClick: (ReactEvent) => Unit = null, onSelect: (ReactEvent) => Unit = null,
                   pullRight: Boolean = false, title: ReactElement = null) extends BoostrapMixinProps

  def apply(className: String = "", bsClass: String = "", bsSize: String = "", bsStyle: String = "",
            dropup: Boolean = false, href: String = "", navItem: Boolean = false,
            noCaret: Boolean = false, onClick: (ReactEvent) => Unit = null, onSelect: (ReactEvent) => Unit = null,
            pullRight: Boolean = false, title: ReactElement = null, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle,
      dropup = dropup, href = href, navItem = navItem,
      noCaret = noCaret, onClick = onClick, onSelect = onSelect,
      pullRight = pullRight, title = title), children)
  }

}
