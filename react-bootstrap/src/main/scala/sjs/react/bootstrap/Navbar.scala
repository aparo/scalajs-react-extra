
package sjs.react.bootstrap

import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object Navbar /* mixins: BootstrapMixin*/ {

  case class State(navExpanded: Boolean = false)

  case class Props(brand: ReactElement = null, className: String = "", bsClass: String = "navbar", bsSize: String = "",
                   bsStyle: String = "default", componentClass: ReactElement = null /*"Nav"*/, defaultNavExpanded: Boolean = false,
                   fixedBottom: Boolean = false, fixedTop: Boolean = false, fluid: Boolean = false,
                   inverse: Boolean = false, navExpanded: Option[Boolean] = None, onToggle: (ReactEvent) => Unit = null,
                   role: String = "navigation", staticTop: Boolean = false, toggleButton: ReactElement = null,
                   toggleNavKey: Any = null) extends BoostrapMixinProps

  def apply(brand: ReactElement = null, className: String = "", bsClass: String = "navbar", bsSize: String = "",
            bsStyle: String = "default", componentClass: ReactElement = null /*"Nav"*/, defaultNavExpanded: Boolean = false,
            fixedBottom: Boolean = false, fixedTop: Boolean = false, fluid: Boolean = false,
            inverse: Boolean = false, navExpanded: Option[Boolean] = None, onToggle: (ReactEvent) => Unit = null,
            role: String = "navigation", staticTop: Boolean = false, toggleButton: ReactElement = null,
            toggleNavKey: Any = null,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) =
    component.set(key, ref)(Props(brand = brand, className = className, bsClass = bsClass, bsSize = bsSize,
      bsStyle = bsStyle, componentClass = componentClass, defaultNavExpanded = defaultNavExpanded,
      fixedBottom = fixedBottom, fixedTop = fixedTop, fluid = fluid,
      inverse = inverse, navExpanded = navExpanded, onToggle = onToggle,
      role = role, staticTop = staticTop, toggleButton = toggleButton, toggleNavKey = toggleNavKey), children)


  class Backend(t: BackendScope[Props, State]) {
    var isChanging = true

    def handleToggle(event: ReactEvent):Unit= {
      if (t.props.onToggle != null) {
        isChanging = true
        t.props.onToggle(event)
        isChanging = false
      }
      t.modState(s => s.copy(navExpanded = !s.navExpanded))
    }
  }

  val component = ReactComponentB[Props]("Navbar")
    .initialStateP(P => State(P.defaultNavExpanded))
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {

        def isNavExpanded: Boolean = if (P.navExpanded.isDefined) P.navExpanded.get else S.navExpanded

        def renderHeader: ReactElement = {
          val brand:TagMod =
            if (P.brand!=null) {
              if (React.isValidElement(P.brand))
                ReactCloneWithProps(P.brand, Map("class" -> "navbar-brand"))
              else
                <.span(^.className := "navbar-brand", P.brand)
            } else null
          <.div(^.className := "navbar-header", brand, if (P.toggleButton != null || P.toggleNavKey != null) renderToggleButton else null)
        }


        def renderToggleButton: ReactElement = {
          if (React.isValidElement(P.toggleButton)) {
            ReactCloneWithProps(P.toggleButton, Map("className" -> "navbar-toggle"
            //TODO restore
//              ,
//              "onClick" -> BootStrapFunctionUtils.createChainedFunction(B.handleToggle , ((P.toggleButton.asInstanceOf[js.Dynamic].props).onClick).asInstanceOf[(ReactEvent) => Unit])
            ))
          }
          val children:List[TagMod] = if (P.toggleButton != null) List(P.toggleButton)
          else List(
            <.span(^.className := "sr-only", ^.key := 0, "Toggle navigation"),
            <.span(^.className := "icon-bar", ^.key := 1),
            <.span(^.className := "icon-bar", ^.key := 2),
            <.span(^.className := "icon-bar", ^.key := 3))

          <.button(^.className := "navbar-toggle", ^.tpe := "button", ^.onClick ==> B.handleToggle, children)
        }

        def renderChild(child: ReactNode, index: Int): ReactElement = {
          val dchild = child.asInstanceOf[js.Dynamic]
          val key: Any = if (child.hasOwnProperty("key")) child.asInstanceOf[js.Dynamic].key else index
          val props: Map[String, Any] = Map(
            "navbar" -> true,
            "collapsable" -> (P.toggleNavKey != null && P.toggleNavKey == dchild.props.eventKey),
            "expanded" -> (P.toggleNavKey != null && P.toggleNavKey == dchild.props.eventKey && isNavExpanded),
            "key" -> key,
            "ref" -> child.asInstanceOf[js.Dynamic].ref
          )
          ReactCloneWithProps(child, props.asInstanceOf[Map[String, js.Any]])
        }


        var classes = P.getBsClassSet
        //      var ComponentClass = P.componentClass
        classes += ("navbar-fixed-top" -> P.fixedTop)
        classes += ("navbar-fixed-bottom" -> P.fixedBottom)
        classes += ("navbar-static-top" -> P.staticTop)
        classes += ("navbar-inverse" -> P.inverse)

        <.nav(^.classSet1M(P.className, classes),
          <.div(^.className := (if (P.fluid) "container-fluid" else "container"),
        if (P.brand != null || P.toggleButton != null || P.toggleNavKey!=null)
          renderHeader else null,
        ValidComponentChildren.map(C, renderChild)) )
      }

    ).shouldComponentUpdate((scope, nextP, nextS) => {
    !scope.backend.isChanging
  })
    .build


}
