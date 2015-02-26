
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object Glyphicon /* mixins: BootstrapMixin*/ {

  val component = ReactComponentB[Props]("Glyphicon")
    .render(
      (P, C) => {
        var classes = P.getBsClassSet
        classes += ("glyphicon-" + P.glyph -> true)
        <.span(^.cls := P.className, ^.classSetM(classes), C)
      }
    )
    .build

  case class Props(glyph: Double, className: Option[String]=None, bsClass: String = "glyphicon", bsSize: String = "",
                   bsStyle: String = "") extends BoostrapMixinProps

  def apply(glyph: Double, bsClass: String = "glyphicon", bsSize: String = "",
            bsStyle: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(glyph = glyph, bsClass = bsClass, bsSize = bsSize,
      bsStyle = bsStyle), children)
  }

}
