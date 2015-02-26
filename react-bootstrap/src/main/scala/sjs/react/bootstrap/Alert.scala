
package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.SetInterval

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object Alert /* mixins: BootstrapMixin*/ {

  case class State(show: Boolean = true)

  class Backend(t: BackendScope[Props, State]) extends SetInterval {
  }

  val component = ReactComponentB[Props]("Alert")
    .initialState(State())
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {
    if (S.show) {

      def renderDismissButton = <.button(^.tpe := "button", ^.className := "close", ^.onClick ==> P.onDismiss, ^.aria.hidden := "true", "\u00d7")


      var classes = P.getBsClassSet
      var isDismissable = P.onDismiss != null
      classes += ("alert-dismissable" -> isDismissable)
      <.div(^.classSet1M(P.className, classes), if (isDismissable) renderDismissButton else null, C)
    } else {
      null //TODO check
    }
  }
    ).componentDidMount(
      scope => {
        if (scope.props.dismissAfter > 0 && scope.props.onDismiss != null) {
          scope.backend.setInterval(scope.modState(_.copy(show = false)), scope.props.dismissAfter)
        }
      }
    ).configure(SetInterval.install)
    .build

  case class Props(className: String = "", bsClass: String = "alert", bsSize: String = "", bsStyle: String = "info",
                   dismissAfter: Int = 0, onDismiss: (ReactEventI) => Unit = null) extends BoostrapMixinProps

  def apply(className: String = "", bsClass: String = "alert", bsSize: String = "", bsStyle: String = "info",
            dismissAfter: Int = 0, onDismiss: (ReactEventI) => Unit = null, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle,
      dismissAfter = dismissAfter, onDismiss = onDismiss), children)
  }

}
