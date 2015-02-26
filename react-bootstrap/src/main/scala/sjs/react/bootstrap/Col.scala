
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js

import japgolly.scalajs.react.vdom.prefix_<^._

object Col /* mixins: */ {

  case class State()

  class Backend(t: BackendScope[Props, State]) {
  }

  val component = ReactComponentB[Props]("Col")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    //    var ComponentClass = P.componentClass
    var classes = Map.empty[String, Boolean]

    var size = "lg"
    var value = P.lg
    if (value > 0) classes += (s"col-$size-$value" -> true)
    value = P.lgOffset
    if (value > 0) classes += (s"col-$size-offset-$value" -> true)
    value = P.lgPush
    if (value > 0) classes += (s"col-$size-push-$value" -> true)
    value = P.lgPull
    if (value > 0) classes += (s"col-$size-pull-$value" -> true)

    size = "md"
    value = P.md
    if (value > 0) classes += (s"col-$size-$value" -> true)
    value = P.mdOffset
    if (value > 0) classes += (s"col-$size-offset-$value" -> true)
    value = P.mdPush
    if (value > 0) classes += (s"col-$size-push-$value" -> true)
    value = P.mdPull
    if (value > 0) classes += (s"col-$size-pull-$value" -> true)

    size = "sm"
    value = P.sm
    if (value > 0) classes += (s"col-$size-$value" -> true)
    value = P.smOffset
    if (value > 0) classes += (s"col-$size-offset-$value" -> true)
    value = P.smPush
    if (value > 0) classes += (s"col-$size-push-$value" -> true)
    value = P.smPull
    if (value > 0) classes += (s"col-$size-pull-$value" -> true)

    size = "xs"
    value = P.xs
    if (value > 0) classes += (s"col-$size-$value" -> true)
    value = P.xsOffset
    if (value > 0) classes += (s"col-$size-offset-$value" -> true)
    value = P.xsPush
    if (value > 0) classes += (s"col-$size-push-$value" -> true)
    value = P.xsPull
    if (value > 0) classes += (s"col-$size-pull-$value" -> true)


    //      return (React.createElement(ComponentClass, React.__spread(Map(), P, ^.cls := ^.classSet1(P.className, classes.toList:_*)), C))
    //    }
    //    P.componentClass(C)
    <.div(^.classSet1M(P.className, classes), C)
  }
    )
    .build

  case class Props(/*componentClass: ReactElement = <.div,*/ lg: Int = 0, lgOffset: Int = 0,
                   lgPull: Int = 0, lgPush: Int = 0, md: Int = 0,
                   mdOffset: Int = 0, mdPull: Int = 0, mdPush: Int = 0,
                   sm: Int = 0, smOffset: Int = 0, smPull: Int = 0,
                   smPush: Int = 0, xs: Int = 0, xsOffset: Int = 0,
                   xsPull: Int = 0, xsPush: Int = 0, className: String = "",
                   bsSize: String = "", bsClass: String = "", bsStyle: String = "") extends BoostrapMixinProps

  def apply(/*componentClass: ReactElement = <.div,*/ lg: Int = 0, lgOffset: Int = 0,
            lgPull: Int = 0, lgPush: Int = 0, md: Int = 0,
            mdOffset: Int = 0, mdPull: Int = 0, mdPush: Int = 0,
            sm: Int = 0, smOffset: Int = 0, smPull: Int = 0,
            smPush: Int = 0, xs: Int = 0, xsOffset: Int = 0,
            xsPull: Int = 0, xsPush: Int = 0, className: String = "",
            bsSize: String = "", bsClass: String = "", bsStyle: String = "", ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(/*componentClass = componentClass, */ lg = lg, lgOffset = lgOffset,
      lgPull = lgPull, lgPush = lgPush, md = md,
      mdOffset = mdOffset, mdPull = mdPull, mdPush = mdPush,
      sm = sm, smOffset = smOffset, smPull = smPull,
      smPush = smPush, xs = xs, xsOffset = xsOffset,
      xsPull = xsPull, xsPush = xsPush, className = className,
      bsSize = bsSize, bsClass = bsClass, bsStyle = bsStyle), children)
  }

}
