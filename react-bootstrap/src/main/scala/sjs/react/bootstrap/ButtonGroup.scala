
package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js


object ButtonGroup /* mixins: BootstrapMixin*/ {


  val component = ReactComponentB[Props]("ButtonGroup")
    .render((P, C) => {
    var classes = P.getBsClassSet
    classes += ("btn-group" -> !P.vertical)
    classes += ("btn-group-vertical" -> P.vertical)
    classes += ("btn-group-justified" -> P.justified)
    <.div(^.classSet1M(P.className, classes), C)
  }
    )
    .build

  case class Props(className: String = "", bsClass: String = "button-group", bsSize: String = "", bsStyle: String = "",
                   justified: Boolean = false, vertical: Boolean = false) extends BoostrapMixinProps

  def apply(className: String = "", bsClass: String = "button-group", bsSize: String = "", bsStyle: String = "",
            justified: Boolean = false, vertical: Boolean = false, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle,
      justified = justified, vertical = vertical), children)
  }

}
