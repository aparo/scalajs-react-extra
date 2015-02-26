
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object Well {

  val component = ReactComponentB[Props]("Well")
    .render(
      (P, C) => {
        val classes = P.getBsClassSet
        <.div(^.classSet1(P.className, classes.toList: _*), C)
      }
    )
    .build

  case class Props(bsClass: String = "well", bsSize: String = "", bsStyle: String = "", className: String = "") extends BoostrapMixinProps

  def apply(bsClass: String = "well", bsSize: String = "", bsStyle: String = "",
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle), children)
  }

}
