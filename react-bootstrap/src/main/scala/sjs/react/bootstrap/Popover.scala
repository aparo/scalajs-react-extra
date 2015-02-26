
package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object Popover /* mixins: BootstrapMixin*/ {


  val component = ReactComponentB[Props]("Popover")
    .render(
      (P, C) => {
        def renderTitle = <.h3(^.className := "popover-title", P.title)


        val classes = Map(
          "popover" -> true,
          P.placement -> true,
          "in" -> (P.positionLeft != 0 || P.positionTop != 0))
        val style = Map(
          "left" -> P.positionLeft,
          "top" -> P.positionTop,
          "display" -> "block").map(v => s"${v._1}:${v._2}px").mkString(";")
        val arrowStyle = Map(
          "left" -> P.arrowOffsetLeft,
          "top" -> P.arrowOffsetTop
        ).map(v => s"${v._1}:${v._2}px").mkString(";")
        <.div(^.classSet1M(P.className, classes), ^.style := style, ^.title := null,
          <.div(^.className := "arrow", ^.style := arrowStyle),
          if (P.title != null) renderTitle() else EmptyTag,
          <.div(^.className := "popover-content", C))
      }
    )
    .build

  case class Props(className: String = "", arrowOffsetLeft: Int = 0, arrowOffsetTop: Int = 0, bsClass: String = "",
                   bsSize: String = "", bsStyle: String = "", placement: String = "right",
                   positionLeft: Int = 0, positionTop: Int = 0, title: ReactElement = null) extends BoostrapMixinProps

  def apply(className: String = "", arrowOffsetLeft: Int = 0, arrowOffsetTop: Int = 0, bsClass: String = "",
            bsSize: String = "", bsStyle: String = "", placement: String = "right",
            positionLeft: Int = 0, positionTop: Int = 0, title: ReactElement = null,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, arrowOffsetLeft = arrowOffsetLeft,
      arrowOffsetTop = arrowOffsetTop, bsClass = bsClass,
      bsSize = bsSize, bsStyle = bsStyle, placement = placement,
      positionLeft = positionLeft, positionTop = positionTop, title = title), children)
  }

}
