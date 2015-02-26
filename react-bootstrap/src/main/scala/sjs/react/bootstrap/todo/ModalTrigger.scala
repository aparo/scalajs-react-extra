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
//object ModalTrigger /* mixins: OverlayMixin*/{
//
//  case class State()
//
//  class Backend(t: BackendScope[Props, State]) {
//  }
//
//  val component = ReactComponentB[Props]("ModalTrigger")
//    .initialState(State())
//    .backend(new Backend(_))
//    .render((P, C, S, B) => {
//    /*
//    function() {
//      var child = React.Children.only(C)
//      return cloneWithProps(child, {onClick: createChainedFunction(child.props.onClick, this.toggle)})
//    }
//*/
//  }
//    )
//    .build
//    /*
//  def show(
//    function() {
//      this.setState({isOverlayShown: true})
//    }
//  )
//*/
///*
//  def getInitialState(
//    function() {
//      return {isOverlayShown: false}
//    }
//  )
//*/
///*
//  def toggle(
//    function() {
//      this.setState({isOverlayShown: !this.state.isOverlayShown})
//    }
//  )
//*/
///*
//  def hide(
//    function() {
//      this.setState({isOverlayShown: false})
//    }
//  )
//*/
///*
//  def renderOverlay(
//    function() {
//      if (!this.state.isOverlayShown)
//      {
//        return React.createElement("span", null)
//      }
//      return cloneWithProps(P.modal, {onRequestHide: this.hide})
//    }
//  )
//*/case class Props(modal:ReactElement) extends BoostrapMixinProps
//def apply(modal:ReactElement, ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*)= {
//   component.set(key, ref)(Props(modal = modal),children)
//}
//
//}
