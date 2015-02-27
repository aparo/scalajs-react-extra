
package sjs.react.bootstrap

import japgolly.scalajs.react.extra.LogLifecycle
import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object Nav /* mixins: BootstrapMixin with CollapsableMixin*/ {

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
        t.props.onSelect(event)
//        t.props.onSelect(t.props.eventKey)
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

    def handleOptionSelect(event: ReactEvent): Unit = {
      if (t.props.onSelect != null) {
        t.props.onSelect(event)
      }
      //      this.setDropdownState(false)
      t.modState(s => s.copy(expanded = false))
    }

  }

  val component = ReactComponentB[Props]("Nav")
    .initialState(State())
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {

        println(s"Navbar In")

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


        def getChildActiveProp(dchild:ReactNode):Boolean= {
          val child = dchild.asInstanceOf[js.Dynamic]

          if (child.props.active.asInstanceOf[Boolean])
          {
            return true
          }
          if (P.activeKey != null)
          {
            if (child.props.eventKey.asInstanceOf[String] == P.activeKey)
            {
              return true
            }
          }
          if (P.activeHref != null)
          {
            if (child.props.href.asInstanceOf[String] == P.activeHref)
            {
              return true
            }
          }
          child.props.active.asInstanceOf[Boolean]
        }


        def renderNavItem(child: ReactNode, index: Int): ReactElement = {
          val dchild = child.asInstanceOf[js.Dynamic]
          val key: js.Any = if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
          val handleOptionSelect: (ReactEvent) => Unit = if (P.onSelect != null || dchild.props.onSelect != null) B.handleOptionSelect else null
          val props: Map[String, js.Any] = Map(
          "active" -> getChildActiveProp(child),
            "onSelect" -> BootStrapFunctionUtils.createChainedFunction(child.asInstanceOf[js.Dynamic].props.onSelect.asInstanceOf[(ReactEvent) => Unit], handleOptionSelect),
            "activeKey" ->  P.activeKey,
            "activeHref" -> P.activeHref,
            "key" -> key,
            "ref" -> child.asInstanceOf[js.Dynamic].ref,
          "navItem" -> true

          )
          ReactCloneWithProps(child, props)
        }


        def renderUl(): ReactElement = {
          var classes = P.getBsClassSet
          classes += ("nav-stacked" -> P.stacked)
          classes += ("nav-justified" -> P.justified)
          classes += ("navbar-nav" -> P.navbar)
          classes += ("pull-right" -> P.pullRight)
          classes += ("navbar-right" -> P.right)
          println("Nav RenderUl")
          <.ul(^.classSet1M(P.className, classes), ^.ref := "ul", ValidComponentChildren.map(C, renderNavItem))
        }



        var classes: Map[String, Boolean] = if (P.collapsable) getCollapsableClassSet(P.className) else Map.empty[String, Boolean]
        classes += ("navbar-collapse" -> P.collapsable)
        println(s"Navbar ${P.navbar}")
        if (P.navbar && !P.collapsable) {
          renderUl()
        } else {
          <.nav(^.classSet1M(P.className, classes), renderUl())
        }
      }
    )
    .configure(LogLifecycle.verbose)
    .build

  /*
def getCollapsableDimensionValue(
  function() {
    var node = this.refs.ul.getDOMNode(), height = node.offsetHeight, computedStyles = domUtils.getComputedStyles(node)
    return height + parseInt(computedStyles.marginTop, 10) + parseInt(computedStyles.marginBottom, 10)
  }
)
*/
  /*

  */
  /*
    def getCollapsableDOMNode(
      function() {
        return this.getDOMNode()
      }
    )
  */
  /*
  */

  case class Props(className: String = "", bsStyle: String = "", bsClass: String = "nav", bsSize: String = "",
                   collapsable: Boolean = false, eventKey: Any = null, expanded: Boolean = false,
                   pullRight: Boolean = false,
                   justified: Boolean = false, navbar: Boolean = false, onSelect: (ReactEvent) => Unit = null,
                   right: Boolean = false, stacked: Boolean = false,
                   activeHref: js.UndefOr[String] = "",
                   activeKey: js.Any = {}) extends BoostrapMixinProps

  def apply(className: String = "", bsStyle: String = "", bsClass: String = "nav", bsSize: String = "",
            collapsable: Boolean = false, eventKey: Any = null, expanded: Boolean = false,
            pullRight: Boolean = false,
            justified: Boolean = false, navbar: Boolean = false, onSelect: (ReactEvent) => Unit = null,
            right: Boolean = false, stacked: Boolean = false,
            activeHref: js.UndefOr[String] = "",
            activeKey: js.Any = {}, ref: js.UndefOr[String] = "",
            key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(className = className, bsStyle = bsStyle, bsClass = bsClass, bsSize = bsSize,
      collapsable = collapsable, eventKey = eventKey, expanded = expanded,
      pullRight = pullRight,
      justified = justified, navbar = navbar, onSelect = onSelect,
      right = right, stacked = stacked, activeHref=activeHref, activeKey=activeKey), children)
  }

}
