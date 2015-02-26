
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object Pager /* mixins: */ {


  val component = ReactComponentB[Props]("Pager")
    .render(
      (P, C) => {
        def renderPageItem(child: ReactNode, index: Int): ReactElement = {
          val key=if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
          val props:Map[String, Any]=Map(
            "onSelect" -> BootStrapFunctionUtils.createChainedFunction(child.asInstanceOf[js.Dynamic].props.onSelect.asInstanceOf[(ReactEvent)=> Unit], P.onSelect),
            "key" -> key,
            "ref" -> child.asInstanceOf[js.Dynamic].ref
          )
          ReactCloneWithProps(child, props.asInstanceOf[Map[String,js.Any]])
        }


        <.ul(^.cls := P.className, ^.cls := "pager", ValidComponentChildren.map(C, renderPageItem))
      }
    )
    .build

  case class Props(className: String = "", onSelect: (ReactEvent) => Unit = null)

  def apply(className: String = "", onSelect: (ReactEvent) => Unit = null, ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, onSelect = onSelect), children)
  }

}
