
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object ProgressBar /* mixins: BootstrapMixin*/ {

  case class State()

  class Backend(t: BackendScope[Props, State]) {
  }

  private def renderScreenReaderOnlyLabel(label: ReactElement): ReactElement = {
    <.span(^.className := "sr-only", label)
  }


  private def getPercentage(now: Double, min: Double, max: Double) = {
    Math.ceil((now - min) / (max - min) * 100)
  }

  private def renderChildBar(child: ReactNode, index: Int): ReactElement = {
    val key = if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
    val props: Map[String, Any] = Map(
      "isChild" -> true,
      "key" -> key,
      "ref" -> child.asInstanceOf[js.Dynamic].ref
    )
    ReactCloneWithProps(child, props.asInstanceOf[Map[String, js.Any]])

  }


  val component = ReactComponentB[Props]("ProgressBar")
    .initialState(State())
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {

        def renderProgressBar: ReactElement = {
          val percentage = getPercentage(P.now, P.min, P.max)
          var label =
          //          if (P.label == "string")
          //          {
          //            this.renderLabel(percentage)
          //          } else
            if (P.label != null) {
              P.label
            } else null
          if (P.srOnly) {
            renderScreenReaderOnlyLabel(label)
          }
          var classes = P.getBsClassSet
          <.div(^.classSet1M(P.className, classes), ^.role := "progressbar", ^.style := s"width:$percentage%",
            ^.aria.valuenow := P.now, ^.aria.valuemin := P.min, ^.aria.valuemax := P.max, label)
        }



        var classes = Map("progress" -> true)
        if (P.active) {
          classes += ("progress-striped" -> true)
          classes += ("active" -> true)
        } else if (P.striped) {
          classes += ("progress-striped" -> true)
        }
        if (!ValidComponentChildren.hasValidComponent(C)) {
          if (!P.isChild) {
            <.div(^.classSet1M(P.className, classes), renderProgressBar)
          } else {
            renderProgressBar
          }
        } else {
          <.div(^.classSet1M(P.className, classes), ValidComponentChildren.map(C, renderChildBar))
        }
      }

    )
    .build

  /*
def renderLabel(
  function(percentage) {
    var InterpolateClass = P.interpolateClass || Interpolate
    return (React.createElement(InterpolateClass, {now: P.now, min: P.min, max: P.max, percent: percentage, bsStyle: P.bsStyle}, P.label))
  }
)
*/

  case class Props(isChild: Boolean = false, active: Boolean = false, className: String = "", bsClass: String = "progress-bar", bsSize: String = "",
                   bsStyle: String = "", label: ReactElement = null, max: Int = 100,
                   min: Int = 0, now: Int = 0, srOnly: Boolean = false,
                   striped: Boolean = false) extends BoostrapMixinProps

  def apply(isChild: Boolean = false, active: Boolean = false, className: String = "",
            bsClass: String = "progress-bar", bsSize: String = "",
            bsStyle: String = "", label: ReactElement = null, max: Int = 100,
            min: Int = 0, now: Int = 0, srOnly: Boolean = false,
            striped: Boolean = false, ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(isChild = isChild, active = active, className = className, bsClass = bsClass, bsSize = bsSize,
      bsStyle = bsStyle, label = label, max = max,
      min = min, now = now, srOnly = srOnly,
      striped = striped), children)
  }

}
