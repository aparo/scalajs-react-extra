//
//package facades.bootstrap
//
//import japgolly.scalajs.react._
//
//import scala.scalajs.js
//import japgolly.scalajs.react.vdom.prefix_<^._
//
//
//
//object Interpolate /* mixins: */{
//
//  case class State()
//
//  class Backend(t: BackendScope[Props, State]) {
//  }
//
//  val component = ReactComponentB[Props]("Interpolate")
//    .initialState(State())
//    .backend(new Backend(_))
//    .render((P, C, S, B) => {
//    /*
//    function() {
//      var format = (ValidComponentChildren.hasValidComponent(C) || (typeof C === "string")) ? C : P.format
//      var parent = P.component
//      var unsafe = P.unsafe === true
//      var props = assign(Map(), P)
//      delete props.children
//      delete props.format
//      delete props.component
//      delete props.unsafe
//      if (unsafe)
//      {
//        var content = format.split(REGEXP).reduce(function(memo, match, index) {
//  var html
//  if (index % 2 === 0)
//  {
//    html = match
//  } else {
//    html = props[match]
//    delete props[match]
//  }
//  if (React.isValidElement(html))
//  {
//    throw new Error("cannot interpolate a React component into unsafe text")
//  }
//  memo += html
//  return memo
//}, "")
//        props.dangerouslySetInnerHTML = {__html: content}
//        return React.createElement(parent, props)
//      } else {
//        var kids = format.split(REGEXP).reduce(function(memo, match, index) {
//  var child
//  if (index % 2 === 0)
//  {
//    if (match.length === 0)
//    {
//      return memo
//    }
//    child = match
//  } else {
//    child = props[match]
//    delete props[match]
//  }
//  memo.push(child)
//  return memo
//}, [])
//        return React.createElement(parent, props, kids)
//      }
//    }
//*/
//  }
//    )
//    .build
//    case class Props(component:String="span", format:String="") extends BoostrapMixinProps
//def apply(component:String="span", format:String="", ref: js.UndefOr[String] = "",
//  key: js.Any = {})(children: ReactNode*)= {
//   component.set(key, ref)(Props(component = component, format = format),children)
//}
//
//}
