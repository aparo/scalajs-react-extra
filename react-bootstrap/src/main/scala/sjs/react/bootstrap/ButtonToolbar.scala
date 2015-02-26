
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object ButtonToolbar /* mixins: BootstrapMixin*/ {

  val component = ReactComponentB[Props]("ButtonToolbar")
    .render(
      (P, C) => {
        <.div(^.role := "toolbar", ^.classSet1M(P.className, P.getBsClassSet), C)
      }
    )
    .build

  case class Props(className: String = "", bsClass: String = "button-toolbar", bsSize: String = "", bsStyle: String = "") extends BoostrapMixinProps

  def apply(className: String = "", bsClass: String = "button-toolbar", bsSize: String = "", bsStyle: String = "",
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle), children)
  }

}
