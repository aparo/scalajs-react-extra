
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object TabbedArea /* mixins: BootstrapMixin*/ {

  case class State(activeKey: Any = null, previousActiveKey: Any = null)

  class Backend(t: BackendScope[Props, State]) {
    var isChanging = false

    def handlePaneAnimateOutEnd() {
      t.setState(State(previousActiveKey = null))
    }

    def handleSelect(key: Any) {
      def getActiveKey = if (t.props.activeKey != null) t.props.activeKey else t.state.activeKey


      if (t.props.onSelect != null) {
        this.isChanging = true
        t.props.onSelect(key)
        this.isChanging = false
      } else if (key != getActiveKey) {
        t.modState(s => s.copy(activeKey = key, previousActiveKey = getActiveKey))
      }
    }
  }

  //  private def getDefaultActiveKeyFromChildren(children) {
  //    var defaultActiveKey;
  //
  //    ValidComponentChildren.forEach(children, function(child) {
  //      if (defaultActiveKey == null) {
  //        defaultActiveKey = child.props.eventKey;
  //      }
  //    });
  //
  //    return defaultActiveKey;
  //  }

  val component = ReactComponentB[Props]("TabbedArea")
    .initialStateP(P => {
    //TODO
    val defaultActiveKey = if (P.defaultActiveKey != null) P.defaultActiveKey else null /*getDefaultActiveKeyFromChildren(C)*/
    State(activeKey = defaultActiveKey, previousActiveKey = null)
  })
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    val activeKey: js.Any = if (P.activeKey != null) P.activeKey else S.activeKey.asInstanceOf[js.Any]


    def renderTab(child: ReactNode) = {
      val key = child.asInstanceOf[js.Dynamic].props.eventKey
      NavItem(ref = "tab" + key, eventKey = key)(child.asInstanceOf[js.Dynamic].props.tab.asInstanceOf[ReactNode])
    }

    def renderPane(child: ReactNode, index: Int): ReactElement = {
      val dchild = child.asInstanceOf[js.Dynamic]
      val key: js.Any = if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
      val props: Map[String, js.Any] = Map(
        "active" -> (dchild.props.eventKey.asInstanceOf[Any] == activeKey && (S.previousActiveKey == null || !P.animation)),
        "animation" -> P.animation,
        "onAnimateOutEnd" -> (if (S.previousActiveKey != null && dchild.props.eventKey.asInstanceOf[Any] == S.previousActiveKey) B.handlePaneAnimateOutEnd else null),
        "key" -> key,
        "ref" -> child.asInstanceOf[js.Dynamic].ref
      )
      ReactCloneWithProps(child, props)

      /*
      *       var activeKey = this.getActiveKey()
      return cloneWithProps(child, {active: , ref: child.ref, key: child.key ? child.key : index, animation: P.animation,
      onAnimateOutEnd: (S.previousActiveKey != null && child.props.eventKey === S.previousActiveKey) ? this.handlePaneAnimateOutEnd : null})

      * */

    }


    def renderTabIfSet(child: ReactNode, pos: Int): ReactElement = {
      //        val dchild=child.asInstanceOf[ReactComponentB[TabPane.Props,Unit,Unit]]
      //      if(dchild.props.tab!=null) renderTab(child) else null
      val dchild = child.asInstanceOf[js.Dynamic]
      if (dchild.props.tab != null) renderTab(child) else null
    }
    val nav: ReactElement = Nav(activeKey = activeKey, onSelect = B.handleSelect, ref = "tabs")(
      ValidComponentChildren.map(C, renderTabIfSet))
    <.div(nav, <.div(/*^.id := P.id,*/ ^.className := "tab-content", ^.ref := "panes", ValidComponentChildren.map(C, renderPane)))
  }
    ).componentWillReceiveProps({
    (scope, nextProps) =>
      if (nextProps.activeKey != null && nextProps.activeKey != scope.props.activeKey) {
        scope.setState(State(previousActiveKey = scope.props.activeKey))
      }

  }).shouldComponentUpdate({
    (scope, P, S) =>
      !scope.backend.isChanging
  })
    .build

  case class Props(animation: Boolean = true, activeKey: js.Any = null, defaultActiveKey: js.Any = null, bsClass: String = "", bsSize: String = "",
                   bsStyle: String = "tabs", onSelect: (Any) => Unit = null) extends BoostrapMixinProps

  def apply(animation: Boolean = true, activeKey: js.Any = null, defaultActiveKey: js.Any = null, bsClass: String = "", bsSize: String = "",
            bsStyle: String = "tabs", onSelect: (Any) => Unit = null, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(animation = animation, activeKey = activeKey, defaultActiveKey = defaultActiveKey,
      bsClass = bsClass, bsSize = bsSize,
      bsStyle = bsStyle, onSelect = onSelect), children)
  }

}
