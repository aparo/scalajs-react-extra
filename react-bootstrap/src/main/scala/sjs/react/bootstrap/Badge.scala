
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object Badge /* mixins: */ {


  val component = ReactComponentB[Props]("Badge")
    .render(
      (P, C) => {

        def hasContent: Boolean =
          (ValidComponentChildren.hasValidComponent(C) /*|| C.isInstanceOf[String]*/ || C.isInstanceOf[Double])

        val classes: Map[String, Boolean] = Map("pull-right" -> P.pullRight, "badge" -> hasContent)
        <.span(^.classSet1M(P.className, classes), C)
      }
    )
    .build

  /*
  //TODO
*/
  case class Props(pullRight: Boolean = false, className: String = "")

  def apply(pullRight: Boolean = false, className: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, pullRight = pullRight), children)
  }

}
