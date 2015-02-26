
package sjs.react.bootstrap

import scala.scalajs.js
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


object Grid /* mixins: */ {


  val component = ReactComponentB[Props]("Grid")
    .render(
      (P, C) => {
        val className = if (P.fluid) "container-fluid" else "container"
        <.div(^.cls := P.className, ^.cls := className, C)
      }
    )
    .build

  case class Props(fluid: Boolean = false, className: String = "")

  def apply(fluid: Boolean = false, className: String = "", ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(fluid = fluid, className = className), children)
  }

}
