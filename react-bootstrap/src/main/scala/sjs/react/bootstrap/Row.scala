
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js

import japgolly.scalajs.react.vdom.prefix_<^._

object Row /* mixins: */ {

  val component = ReactComponentB[Props]("Row")
    .render(
      (P, C) => {
        <.div(^.className := P.className, ^.className := "row", C)
      }
    )
    .build

  case class Props(className: Option[String] = None)

  def apply(className: Option[String] = None, ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className), children)
  }

}
