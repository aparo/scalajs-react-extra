
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object SubNav /* mixins: BootstrapMixin*/ {

  case class State()

  class Backend(t: BackendScope[Props, State]) {
    def handleClick(event: ReactEvent) {
      if (t.props.onSelect != null) {
        event.preventDefault()
        if (!t.props.disabled) {
          t.props.onSelect(t.props.eventKey, t.props.href, t.props.target)
        }
      }
    }
  }

  val component = ReactComponentB[Props]("SubNav")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, C, S, B) => {
//    def isActive: Boolean = isChildActive(C)

    def isChildActive(child: ReactElement): Boolean = {
      val dchild = child.asInstanceOf[js.Dynamic]
      if (dchild.props.active.asInstanceOf[Boolean]) {
        return true
      }
      if (P.activeKey != null && P.activeKey == dchild.props.eventKey.asInstanceOf[Any]) {
        return true
      }
      if (P.activeHref != null && P.activeHref == dchild.props.href.asInstanceOf[Any]) {
        return true
      }
      //TODO
      //      if (dchild.props.children!=null)
      //      {
      //        var isActive = false
      //        ValidComponentChildren.forEach(dchild.props.children, function(dchild) {
      //          if (isChildActive(dchild))
      //          {
      //            isActive = true
      //          }
      //        }, this)
      //        return isActive
      //      }
      false
    }

    def getChildActiveProp(dchild: ReactNode): Boolean = {
      val child = dchild.asInstanceOf[js.Dynamic]
      if (child.props.active != null && child.props.active.asInstanceOf[Boolean]) {
        return true
      }
      if (P.activeKey != null) {
        if (child.props.eventKey == P.activeKey) {
          return true
        }
      }
      if (P.activeHref != null) {
        if (child.props.href.asInstanceOf[Any] == P.activeHref) {
          return true
        }
      }
      child.props.active.asInstanceOf[Boolean]
    }


    def renderNavItem(child: ReactNode, index: Int): ReactElement = {
      val key:js.Any = if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
      val props: Map[String, js.Any] = Map(
        "active" -> getChildActiveProp(child),
        "onSelect" -> BootStrapFunctionUtils.createChainedFunction(child.asInstanceOf[js.Dynamic].props.onSelect.asInstanceOf[(Any, String, String) => Unit], P.onSelect),
        "key" -> key,
        "ref" -> child.asInstanceOf[js.Dynamic].ref
      )

      ReactCloneWithProps(child, props)

    }

    val classes = Map(
//      "active" -> isActive,
      "disabled" -> P.disabled)
    <.li(^.classSet1M(P.className, classes),
      <.a(^.href := P.href, ^.title := P.title, ^.target := P.target, ^.onClick ==> B.handleClick, ^.ref := "anchor", P.text),
      <.ul(^.className := "nav", ValidComponentChildren.map(C, renderNavItem)))
  }
    )
    .build

  case class Props(active: Boolean = false, className: String = "", bsClass: String = "nav", bsSize: String = "",
                   bsStyle: String = "", disabled: Boolean = false, href: String = "",
                   onSelect: (Any, String, String) => Unit = null, target: String = "", text: ReactElement = null, activeKey: Any = null,
                   activeHref: String = "", eventKey: Any = null,
                   title: String = "") extends BoostrapMixinProps

  def apply(active: Boolean = false, className: String = "", bsClass: String = "nav", bsSize: String = "",
            bsStyle: String = "", disabled: Boolean = false, href: String = "", activeHref: String = "",
            onSelect: (Any, String, String) => Unit = null, target: String = "", text: ReactElement = null, activeKey: Any = null,
            title: String = "", eventKey: Any = null, ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(active = active, className = className, bsClass = bsClass, bsSize = bsSize,
      bsStyle = bsStyle, disabled = disabled, href = href, activeKey = activeKey, activeHref = activeHref, eventKey = eventKey,
      onSelect = onSelect, target = target, text = text,
      title = title), children)
  }

}
