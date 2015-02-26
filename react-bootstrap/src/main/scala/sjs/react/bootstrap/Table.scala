
package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object Table /* mixins: */ {


  val component = ReactComponentB[Props]("Table")
    .render((P, C) => {
    val classes = Map(
      "table" -> true, "table-striped" -> P.striped, "table-bordered" -> P.bordered,
      "table-condensed" -> P.condensed, "table-hover" -> P.hover
    )
    val table = <.table(^.classSet1M(P.className, classes), C)
    if (P.responsive)
      <.div(^.className := "table-responsive", table)
    else
      table
  }
    )
    .build

  case class Props(className: String = "", bordered: Boolean = false, condensed: Boolean = false, hover: Boolean = false,
                   responsive: Boolean = false, striped: Boolean = false)

  def apply(className: String = "", bordered: Boolean = false, condensed: Boolean = false, hover: Boolean = false,
            responsive: Boolean = false, striped: Boolean = false, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bordered = bordered, condensed = condensed, hover = hover,
      responsive = responsive, striped = striped), children)
  }

}
