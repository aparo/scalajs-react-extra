
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object Tooltip {

  val component = ReactComponentB[Props]("Tooltip")
    .render((P, C) => {
    val classes = Map(
      "tooltip" -> true,
      P.placement -> true,
      "in" -> (P.positionLeft != 0 || P.positionTop != 0))
    val style = Map(
      "left" -> P.positionLeft,
      "top" -> P.positionTop).map(v => s"${v._1}:${v._2}px").mkString(";")
    val arrowStyle = Map(
      "left" -> P.arrowOffsetLeft,
      "top" -> P.arrowOffsetTop).map(v => s"${v._1}:${v._2}px").mkString(";")
    <.div(^.classSet1M(P.className, classes), ^.style := style,
      <.div(^.className := "tooltip-arrow", ^.style := arrowStyle),
      <.div(^.className := "tooltip-inner"), C

    )
  }
    )
    .build

  case class Props(className: String = "", arrowOffsetLeft: Int = 0, arrowOffsetTop: Int = 0, bsClass: String = "",
                   bsSize: String = "", bsStyle: String = "", placement: String = "right",
                   positionLeft: Int = 0, positionTop: Int = 0) extends BoostrapMixinProps

  def apply(className: String = "", arrowOffsetLeft: Int = 0, arrowOffsetTop: Int = 0, bsClass: String = "",
            bsSize: String = "", bsStyle: String = "", placement: String = "right",
            positionLeft: Int = 0, positionTop: Int = 0, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, arrowOffsetLeft = arrowOffsetLeft, arrowOffsetTop = arrowOffsetTop, bsClass = bsClass,
      bsSize = bsSize, bsStyle = bsStyle, placement = placement,
      positionLeft = positionLeft, positionTop = positionTop), children)
  }

}
