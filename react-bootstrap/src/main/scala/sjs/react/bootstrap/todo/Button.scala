//
//package facades.bootstrap.todo
//
//import japgolly.scalajs.react._
//
//import scala.scalajs.js
//
//
//
//object Button /* mixins: BootstrapMixin*/{
//
//  case class State()
//
//  class Backend(t: BackendScope[Props, State]) {
//  }
//
//  val component = ReactComponentB[Props]("Button")
//    .initialState(State())
//    .backend(new Backend(_))
//    .render((P, C, S, B) => {
//    /*
//    function() {
//      var classes = P.navDropdown ? Map() : P.getBsClassSet()
//      var renderFuncName
//      classes += ("active" -> P.active)
//      classes += ("btn-block" -> P.block)
//      if (P.navItem)
//      {
//        return this.renderNavItem(classes)
//      }
//      renderFuncName = P.href || P.target || P.navDropdown ? "renderAnchor" : "renderButton"
//      return this[renderFuncName](classes)
//    }
//*/
//  }
//    )
//    .build
//    /*
//  def renderAnchor(
//    function(classes) {
//      var Component = P.componentClass || "a"
//      var href = P.href || "#"
//      classes += ("disabled" -> P.disabled)
//      return (React.createElement(Component, React.__spread(Map(), P, {href: href, className: joinClasses(P.className, classSet(classes)), role: "button"}), C))
//    }
//  )
//*/
///*
//  def renderNavItem(
//    function(classes) {
//      var liClasses = {active: P.active}
//      return (React.createElement("li", {className: classSet(liClasses)}, this.renderAnchor(classes)))
//    }
//  )
//*/
///*
//  def renderButton(
//    function(classes) {
//      var Component = P.componentClass || "button"
//      return (React.createElement(Component, React.__spread(Map(), P, ^.cls := ^.classSet1(P.className, classes.toList:_*)), C))
//    }
//  )
//*/case class Props(active:Boolean=false, block:Boolean=false, bsClass:String="button",
//  bsSize:String="", bsStyle:String="default", componentClass:ReactElement=null,
//  disabled:Boolean=false, href:String="", navDropdown:Boolean=false,
//  navItem:Boolean=false, target:String="", type:String="button") extends BoostrapMixinProps
//def apply(active:Boolean=false, block:Boolean=false, bsClass:String="button",
//  bsSize:String="", bsStyle:String="default", componentClass:ReactElement=null,
//  disabled:Boolean=false, href:String="", navDropdown:Boolean=false,
//  navItem:Boolean=false, target:String="", type:String="button",
//  ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*)= {
//   component.set(key, ref)(Props(active = active, block = block, bsClass = bsClass,
//  bsSize = bsSize, bsStyle = bsStyle, componentClass = componentClass,
//  disabled = disabled, href = href, navDropdown = navDropdown,
//  navItem = navItem, target = target, type = type),children)
//}
//
//}
