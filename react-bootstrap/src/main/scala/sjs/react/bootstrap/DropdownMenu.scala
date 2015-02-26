
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object DropdownMenu /* mixins: */ {


  val component = ReactComponentB[Props]("DropdownMenu")
    .render(
      (P, C) => {
        def renderMenuItem(child: ReactNode, index: Int): ReactElement = {
          val key = if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
          val props: Map[String, Any] = Map(
            "onSelect" -> BootStrapFunctionUtils.createChainedFunction(child.asInstanceOf[js.Dynamic].props.onSelect.asInstanceOf[(ReactEvent) => Unit], P.onSelect),
            "key" -> key,
            "ref" -> child.asInstanceOf[js.Dynamic].ref
          )
          ReactCloneWithProps(child, props.asInstanceOf[Map[String, js.Any]])

        }

        val classes = Map("dropdown-menu" -> true, "dropdown-menu-right" -> P.pullRight)
        <.ul(^.classSet1M(P.className, classes), ^.role := "menu", ValidComponentChildren.map(C, renderMenuItem))
      }
    )
    .build

  case class Props(className: String = "", onSelect: (ReactEvent) => Unit = null, pullRight: Boolean = false)

  def apply(className: String = "", onSelect: (ReactEvent) => Unit = null, pullRight: Boolean = false, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, onSelect = onSelect, pullRight = pullRight), children)
  }

}
