
package sjs.react.bootstrap

import scala.scalajs.js
import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object PanelGroup {

  case class State(activeKey: Any = null)

  class Backend(t: BackendScope[Props, State]) {
    var isChanging=false
    def handleSelect(key:Any)(event:ReactEvent): Unit ={
      var currKey=key
      if(t.props.onSelect!=null){
        this.isChanging = true
        t.props.onSelect(event)
        this.isChanging = false
      }
      if (t.state.activeKey == currKey)
      {
        currKey = null
      }
      t.setState(t.state.copy(activeKey = key))
    }

  }

  val component = ReactComponentB[Props]("PanelGroup")
    .initialStateP(P => State(activeKey = P.defaultActiveKey))
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {

        def renderPanel(child: ReactNode, index: Int): ReactElement = {

          def getBSStyle: Any = {
            if (child.hasOwnProperty("props")) {
              val props = child.asInstanceOf[js.Dynamic].props
              if (props.asInstanceOf[js.Object].hasOwnProperty("bsStyle")) {
                return props.asInstanceOf[js.Dynamic].bsStyle
              }
            }
            P.bsStyle
          }
          val key=(if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index)
          val activeKey = if (P.activeKey != null) P.activeKey else S.activeKey
          var props: Map[String, Any] = Map(
            "bsStyle" -> getBSStyle,
            "key" -> key,
            "ref" -> child.asInstanceOf[js.Dynamic].ref
          )
          if (P.accordion) {
            props += ("collapsable" -> true)
            props += ("expanded" -> (child.asInstanceOf[js.Dynamic].props.eventKey.asInstanceOf[Any] == activeKey))
            props += ("onSelect" -> (B.handleSelect(key) _) )
          }

          ReactCloneWithProps(child, props.asInstanceOf[Map[String,js.Any]])
        }


        val classes = P.getBsClassSet
        <.div(^.classSet1M(P.className, classes) /*,  onSelect: null})*/ , ValidComponentChildren.map(C, renderPanel))
      }
    ).shouldComponentUpdate((scope, nextP, nextS) => {
    ! scope.backend.isChanging
  })
    .build

  case class Props(className: String = "", activeKey: Any = null, bsClass: String = "panel-group", bsSize: String = "",
                    bsStyle: String = "", collapsable: Boolean = false, defaultActiveKey: Any = null,
                    onSelect: (ReactEvent) => Unit = null, accordion: Boolean = false) extends BoostrapMixinProps

  def apply(className: String = "", activeKey: Any = null, bsClass: String = "panel-group", bsSize: String = "",
            bsStyle: String = "", collapsable: Boolean = false, accordion: Boolean = false, defaultActiveKey: Any = null,
            onSelect: (ReactEvent) => Unit = null, ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, activeKey = activeKey, bsClass = bsClass, bsSize = bsSize,
      bsStyle = bsStyle, collapsable = collapsable, accordion = accordion, defaultActiveKey = defaultActiveKey,
      onSelect = onSelect), children)
  }

}
