
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object Label {

  val component = ReactComponentB[Props]("Label")
    .render(
      (P, C) => {
        val classes = P.getBsClassSet
        <.span(^.classSet1M(P.className, classes), C)
      }
    )
    .build

  case class Props(className: String = "", bsClass: String = "label", bsSize: String = "", bsStyle: String = "default") extends BoostrapMixinProps

  def apply(className: String = "", bsClass: String = "label", bsSize: String = "", bsStyle: String = "default",
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle), children)
  }

}
