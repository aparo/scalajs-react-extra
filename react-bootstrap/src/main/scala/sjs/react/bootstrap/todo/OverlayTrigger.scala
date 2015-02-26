//
//package facades.bootstrap
//
//import japgolly.scalajs.react.Addons.ReactCloneWithProps
//import japgolly.scalajs.react._
//import org.scalajs.dom
//import org.scalajs.dom.Node
//
//import scala.scalajs.js
//import japgolly.scalajs.react.vdom.prefix_<^._
//
//
//object OverlayTrigger /* mixins: OverlayMixin*/ {
//
//  case class Props(overlay: ReactElement, defaultOverlayShown: Boolean = false, delay: Int = 0,
//                   delayHide: Int = 0, delayShow: Int = 0, placement: String = "right",
//                   trigger: List[String] = List("hover", "focus")){
//    var container:Node=dom.document.body
//  }
//
//
//  case class State(isOverlayShown: Boolean = false, overlayLeft:Int=0, overlayTop:Int=0)
//
//  case class Position(top:Int=null, left:Int=null, height:Int=null, width:Int=null)
//
//  class Backend(t: BackendScope[Props, State]) {
//    def hide() {
//      t.modState(s => s.copy(isOverlayShown = false))
//    }
//
//    def updateOverlayPosition() {
//      if (!t.isMounted()){return}
//      val pos = calcOverlayPosition()
//      t.setState(State(overlayLeft= pos.left, overlayTop= pos.top))
//    }
//    def show() {
//      t.setState(State(isOverlayShown= true), () => {
//        this.updateOverlayPosition()
//      })
//    }
//
//    def handleDelayedHide() {
//      if (_hoverDelay != null)
//      {
//        clearTimeout(this._hoverDelay)
//        _hoverDelay = null
//        return
//      }
//      var delay = P.delayHide != null ? P.delayHide : P.delay
//      if (!delay)
//      {
//        this.hide()
//        return
//      }
//      this._hoverDelay = setTimeout(function() {
//        this._hoverDelay = null
//        this.hide()
//      }.bind(this), delay)
//    }
//
//    def toggle() {
//      if(t.state.isOverlayShown) this.hide() else this.show()
//    }
//
//    def getPosition():Position= {
//      val node = t.getDOMNode()
//      val container = getContainerDOMNode()
//      val offset = if(container.tagName == "BODY") domutils.getOffset(node) else domUtils.getPosition(node, container)
//      Potision(height= node.offsetHeight, width= node.offsetWidth)
//    }
//
//
//
//    def calcOverlayPosition():Position= {
//      val childOffset = getPosition()
//      val overlayNode = this.getOverlayDOMNode()
//      val overlayHeight = overlayNode.offsetHeight
//      val overlayWidth = overlayNode.offsetWidth
//      t.props.placement match {
//        case "right"=>
//        Position(top=childOffset.top + childOffset.height / 2 - overlayHeight / 2,
//          left=childOffset.left + childOffset.width)
//        case "left"=>
//      Position(top= childOffset.top + childOffset.height / 2 - overlayHeight / 2, left= childOffset.left - overlayWidth)
//        case "top"=>
//        Position(top= childOffset.top - overlayHeight, left= childOffset.left + childOffset.width / 2 - overlayWidth / 2)
//        case "bottom"=>
//        Position(top= childOffset.top + childOffset.height, left= childOffset.left + childOffset.width / 2 - overlayWidth / 2)
//        case _ =>
//          throw new Error(s"calcOverlayPosition(): No such placement of ${t.props.placement} found.")
//      }
//    }
//
//    def getOverlayDOMNode():Node= {
//      if (! t.isMounted()) {
//        throw new Error("getOverlayDOMNode(): A component must be mounted to have a DOM node.")
//      }
//
////      if (this._overlayInstance) {
////        return this._overlayInstance.getDOMNode()
////      }
//
//      null
//    }
//
//    def getContainerDOMNode():Node = {
//      if(t.props.container.getDOMNode!=null)
//        t.props.container.getDOMNode()
//      else
//        t.props.container
//    }
//
//
//  }
//
//
//    val component = ReactComponentB[Props]("OverlayTrigger")
//      .initialStateP({
//      P=>
//        //return {, }
//
//        State(isOverlayShown= if(P.defaultOverlayShown == null)  false else P.defaultOverlayShown,
//          overlayLeft= null, overlayTop= null)
//    }
//    )
//      .backend(new Backend(_))
//      .render(
//        (P, C, S, B) => {
//
//          if (P.trigger.contains("manual")) {
//            React.Children.only(C).asInstanceOf[ReactElement]
//          } else {
//            var props = Map.empty[String, Any]
//            if (P.trigger.contains("click")) {
//              props += ("onClick" -> BootStrapFunctionUtils.createChainedFunction(B.toggle, P.onClick))
//            }
//            if (P.trigger.contains("hover")) {
//              props += ("onMouseOver" -> BootStrapFunctionUtils.createChainedFunction(B.handleDelayedShow, P.onMouseOver))
//              props += ("onMouseOut" -> BootStrapFunctionUtils.createChainedFunction(B.handleDelayedHide, P.onMouseOut))
//            }
//            if (P.trigger.contains("focus")) {
//              props += ("onFocus" -> BootStrapFunctionUtils.createChainedFunction(B.handleDelayedShow, P.onFocus))
//              props += ("onBlur" -> BootStrapFunctionUtils.createChainedFunction(B.handleDelayedHide, P.onBlur))
//            }
//            ReactCloneWithProps(React.Children.only(C), props).asInstanceOf[ReactElement]
//
//          }
//
//        }
//      ).componentDidMount(scope => scope.backend.updateOverlayPosition())
//      .build
//
//    /*
//
//      )
//    */
//    /*
//
//    */
//    /*
//    */
//    /*
//      def handleDelayedShow(
//        function() {
//          if (this._hoverDelay != null)
//          {
//            clearTimeout(this._hoverDelay)
//            this._hoverDelay = null
//            return
//          }
//          var delay = P.delayShow != null ? P.delayShow : P.delay
//          if (!delay)
//          {
//            this.show()
//            return
//          }
//          this._hoverDelay = setTimeout(function() {
//      this._hoverDelay = null
//      this.show()
//    }.bind(this), delay)
//        }
//      )
//    */
//    /*
//      def renderOverlay(
//        function() {
//          if (!this.state.isOverlayShown)
//          {
//            return React.createElement("span", null)
//          }
//          return cloneWithProps(P.overlay, {onRequestHide: this.hide, placement: P.placement, positionLeft: this.state.overlayLeft, positionTop: this.state.overlayTop})
//        }
//      )
//    */
//    /*
//      def componentWillUnmount(
//        function() {
//          clearTimeout(this._hoverDelay)
//        }
//      )
//    */
//    def apply(overlay: ReactElement, defaultOverlayShown: Boolean = false, delay: Int = 0,
//              delayHide: Int = 0, delayShow: Int = 0, placement: String = "right",
//              trigger: List[String] = List("hover", "focus"), ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
//      component.set(key, ref)(Props(overlay = overlay, defaultOverlayShown = defaultOverlayShown, delay = delay,
//        delayHide = delayHide, delayShow = delayShow, placement = placement,
//        trigger = trigger), children)
//
//
//    }
