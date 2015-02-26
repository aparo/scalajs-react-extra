
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object ListGroup /* mixins: */ {


  val component = ReactComponentB[Props]("ListGroup")
    .render(
      (P, C) => {

        def renderListItem(child: ReactNode, index: Int): ReactElement = {
          val key = if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
          val props: Map[String, Any] = Map(
            "onClick" -> BootStrapFunctionUtils.createChainedFunction(child.asInstanceOf[js.Dynamic].props.onClick.asInstanceOf[(ReactEvent) => Unit], P.onClick),
            "key" -> key,
            "ref" -> child.asInstanceOf[js.Dynamic].ref
          )
          ReactCloneWithProps(child, props.asInstanceOf[Map[String, js.Any]])
        }
        <.div(^.className := "list-group", ValidComponentChildren.map(C, renderListItem))
      }
    )
    .build


  case class Props(onClick: (ReactEvent) => Unit = null)

  def apply(onClick: (ReactEvent) => Unit = null, ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(onClick = onClick), children)
  }

}
