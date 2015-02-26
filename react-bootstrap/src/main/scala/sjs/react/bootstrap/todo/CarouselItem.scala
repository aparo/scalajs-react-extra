//
//package facades.bootstrap.todo
//
//import facades.bootstrap.BoostrapMixinProps
//import japgolly.scalajs.react._
//
//import scala.scalajs.js
//
//
//
//object CarouselItem /* mixins: */{
//
//  case class State()
//
//  class Backend(t: BackendScope[Props, State]) {
//  }
//
//  val component = ReactComponentB[Props]("CarouselItem")
//    .initialState(State())
//    .backend(new Backend(_))
//    .render((P, C, S, B) => {
//    /*
//    function() {
//      var classes = {item: true, active: (P.active && !P.animateIn) || P.animateOut, next: P.active && P.animateIn && P.direction === "next", prev: P.active && P.animateIn && P.direction === "prev"}
//      if (this.state.direction && (P.animateIn || P.animateOut))
//      {
//        classes[this.state.direction] = true
//      }
//      return (React.createElement("div", React.__spread(Map(), P, ^.cls := ^.classSet1(P.className, classes.toList:_*)), C, P.caption ? this.renderCaption() : null))
//    }
//*/
//  }
//    )
//    .build
//    /*
//  def componentWillReceiveProps(
//    function(nextProps) {
//      if (P.active !== nextProps.active)
//      {
//        this.setState({direction: null})
//      }
//    }
//  )
//*/
///*
//  def getInitialState(
//    function() {
//      return {direction: null}
//    }
//  )
//*/
///*
//  def componentDidUpdate(
//    function(prevProps) {
//      if (!P.active && prevProps.active)
//      {
//        TransitionEvents.addEndEventListener(this.getDOMNode(), this.handleAnimateOutEnd)
//      }
//      if (P.active !== prevProps.active)
//      {
//        setTimeout(this.startAnimation, 20)
//      }
//    }
//  )
//*/
///*
//  def handleAnimateOutEnd(
//    function() {
//      if (P.onAnimateOutEnd && this.isMounted())
//      {
//        P.onAnimateOutEnd(P.index)
//      }
//    }
//  )
//*/
///*
//  def renderCaption(
//    function() {
//      return (React.createElement("div", {className: "carousel-caption"}, P.caption))
//    }
//  )
//*/
///*
//  def startAnimation(
//    function() {
//      if (!this.isMounted())
//      {
//        return
//      }
//      this.setState({direction: P.direction === "prev" ? "right" : "left"})
//    }
//  )
//*/case class Props(direction:String, active:Boolean=false, animation:Boolean=true,
//  caption:ReactElement=null, onAnimateOutEnd:(ReactEventI) => Unit=null) extends BoostrapMixinProps
//def apply(direction:String, active:Boolean=false, animation:Boolean=true,
//  caption:ReactElement=null, onAnimateOutEnd:(ReactEventI) => Unit=null, ref: js.UndefOr[String] = "",
//  key: js.Any = {})(children: ReactNode*)= {
//   component.set(key, ref)(Props(direction = direction, active = active, animation = animation,
//  caption = caption, onAnimateOutEnd = onAnimateOutEnd),children)
//}
//
//}
