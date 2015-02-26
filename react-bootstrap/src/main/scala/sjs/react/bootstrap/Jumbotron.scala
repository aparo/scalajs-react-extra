
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object Jumbotron {


  val component = ReactComponentB[Props]("Jumbotron")
    .render(
      (P, C) => {
        <.div(^.cls := P.className, ^.cls := "jumbotron", C)
      }
    )
    .build

  case class Props(className: Option[String] = None, bsClass: String = "", bsSize: String = "",
                   bsStyle: String = "") extends BoostrapMixinProps

  def apply(className: Option[String] = None, bsClass: String = "", bsSize: String = "",
            bsStyle: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle), children)
  }

}
