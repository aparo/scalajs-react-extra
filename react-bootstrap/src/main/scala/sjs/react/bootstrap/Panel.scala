
package sjs.react.bootstrap

import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.collection.mutable.ListBuffer
import scala.scalajs.js


object Panel /* mixins: BootstrapMixin with CollapsableMixin*/ {

  case class State(expanded: Boolean = false,
                   collapsable: Boolean = false,
                   collapsing: Boolean = false,
                   defaultExpanded: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {
    var _isChanging = false
    var _collapseEnd = true

    def getCollapsableDimensionValue(): Int = {
      t.refs.asInstanceOf[js.Dynamic].panel.getDOMNode().scrollHeight.asInstanceOf[Int]
    }

    def getCollapsableDOMNode() = {
      if (!t.isMounted() || t.refs == null || t.refs.asInstanceOf[js.Dynamic].panel == null) {
        null
      }
      t.refs.asInstanceOf[js.Dynamic].panel.getDOMNode()
    }

    def handleSelect(event: ReactEvent) {
      if (t.props.onSelect != null) {
        this._isChanging = true
        t.props.onSelect(t.props.eventKey)
        this._isChanging = false
      }
      event.preventDefault()
      t.modState(s => s.copy(expanded = !s.expanded))
    }

    def handleTransitionEnd() {
      _collapseEnd = true
      t.modState(_.copy(collapsing = false)) //setState({
    }

    def _addEndTransitionListener() {
      val node = getCollapsableDOMNode()

      //      if (node!=null) {
      //        ReactTransitionEvents.addEndEventListener(
      //          node,
      //          this.handleTransitionEnd
      //        )
      //      }
    }

    def _removeEndTransitionListener() {
      var node = getCollapsableDOMNode()

      //      if (node!=null) {
      //        TransitionEvents.removeEndEventListener(
      //          node,
      //          this.handleTransitionEnd
      //        );
      //      }
    }
  }

  val component = ReactComponentB[Props]("Panel")
    .initialStateP(P => State(collapsing = false, expanded = P.defaultExpanded))
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {

        def isExpanded: Boolean = {
          if (P.expanded)
            P.expanded
          else S.expanded
        }


        def getCollapsableClassSet(className: String): Map[String, Boolean] = {
          var classes = Map.empty[String, Boolean]

          if (className.isInstanceOf[String]) {
            className.split(' ').foreach {
              s =>
                classes += (s -> true)
            }
          }

          classes += ("collapsing" -> S.collapsing)
          classes += ("collapse" -> !S.collapsing)
          classes += ("in" -> (isExpanded && !S.collapsing))
          classes
        }

        def renderFooter(): ReactNode = {
          if (P.footer != null) {
            <.div(^.className := "panel-footer", P.footer)
          } else null

        }

        def renderAnchor(header: ReactNode): ReactNode = {
          <.a(^.href := "#" + (if (P.id.nonEmpty) P.id else ""),
            ^.className := (if (isExpanded) null else "collapsed"),
            ^.onClick ==> B.handleSelect, header)
        }



        def renderCollapsableTitle(header: ReactNode): ReactNode = {
          <.h4(^.className := "panel-title", renderAnchor(header))
        }

        def renderCollapsableBody(): ReactNode = {
          <.div(^.classSetM(getCollapsableClassSet("panel-collapse")), ^.id := P.id, ^.ref := "panel", renderBody())
        }

        def renderHeading(): ReactNode = {
          var header = P.header
          if (header == null) {
            return null
          }
          val toRender = if (!React.isValidElement(header) || js.Array.isArray(header)) {
            if (P.collapsable)
              renderCollapsableTitle(header)
            else header
          } else if (P.collapsable) {
            ReactCloneWithProps(header, Map("class" -> "panel-title", "children" -> renderAnchor(header.asInstanceOf[js.Dynamic].props.children.asInstanceOf[ReactNode])))
          } else {
            ReactCloneWithProps(header, Map("class" -> "panel-title"))
          }
          <.div(^.className := "panel-heading", toRender)
        }

        def shouldRenderFill(child: ReactNode): Boolean = {
          React.isValidElement(child) && child.asInstanceOf[js.Dynamic].props.fill != null
        }

        def renderBody(): ReactNode = {
          val allChildren = C
          var bodyElements = new ListBuffer[ReactNode]()
          def getProps: Map[String, js.Any] = Map("key" -> bodyElements.length)

          def addPanelChild(child: ReactNode) {
            bodyElements += ReactCloneWithProps(child, getProps)
          }
          def addPanelBody(children: ReactNode*) {
            bodyElements += <.div(^.className := "panel-body", ^.key := bodyElements.length, children)
          }
          if (!js.Array.isArray(allChildren) || allChildren.asInstanceOf[js.Array[_]].length == 0) {
            if (shouldRenderFill(allChildren)) {
              addPanelChild(allChildren)
            } else {
              addPanelBody(allChildren)
            }
          } else {
            var panelBodyChildren = new ListBuffer[ReactNode]()
            def maybeRenderPanelBody() {
              if (panelBodyChildren.length == 0) {
                return
              }
              addPanelBody(panelBodyChildren: _*)
              panelBodyChildren = new ListBuffer[ReactNode]()
            }

            allChildren.forEach(child => {
              if (shouldRenderFill(child)) {
                maybeRenderPanelBody()
                addPanelChild(child)
              } else {
                panelBodyChildren += child
              }
            } /*.bind(this)*/)

            maybeRenderPanelBody()
          }
          bodyElements
        }




        var classes = P.getBsClassSet
        classes += ("panel" -> true)
        <.div(^.classSet1M(P.className, classes), ^.id := (if (P.collapsable) null else P.id),
          renderHeading(), if (P.collapsable) renderCollapsableBody() else renderBody(),
          renderFooter())
      }
    ).componentWillReceiveProps((scope, newProps) => {
    if (scope.props.collapsable && newProps.expanded != scope.props.expanded) {
      scope.backend._collapseEnd = false
      scope.setState(State(collapsing = true))
    }

  })
    .shouldComponentUpdate(
      (scope, P, S) =>
        !scope.backend._isChanging
    ).componentDidMount(scope => {

  })
    .build

  case class Props(id: String = "", collapsable: Boolean = false, className: String = "",
                      defaultExpanded: Boolean = false, expanded: Boolean = false,
                      bsClass: String = "panel", bsSize: String = "", bsStyle: String = "default",
                      eventKey: Any = null, footer: ReactElement = null, header: ReactElement = null,
                      onSelect: (Any) => Unit = null) extends BoostrapMixinProps

  def apply(id: String = null, collapsable: Boolean = false, className: String = "",
            defaultExpanded: Boolean = false, expanded: Boolean = false,
            bsClass: String = "panel", bsSize: String = "", bsStyle: String = "default",
            eventKey: Any = null, footer: ReactElement = null, header: ReactElement = null,
            onSelect: (Any) => Unit = null, ref: js.UndefOr[String] = "", key: js.Any = {
  })(children: ReactNode*) = {
    component.set(key, ref)(Props(id = id, collapsable = collapsable, className = className,
      defaultExpanded = defaultExpanded, expanded = expanded,
      bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle,
      eventKey = eventKey, footer = footer, header = header,
      onSelect = onSelect), children)
  }

}
