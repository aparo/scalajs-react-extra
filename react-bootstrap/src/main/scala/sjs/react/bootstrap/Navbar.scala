
package sjs.react.bootstrap

import japgolly.scalajs.react.extra.LogLifecycle
import japgolly.scalajs.react.vdom.Attr
import sjs.react.bootstrap.utils.ValidComponentChildren
import japgolly.scalajs.react.Addons.ReactCloneWithProps
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import sjs.utils.IDGenerator

import scala.scalajs.js


object Navbar /* mixins: BootstrapMixin*/ {

  case class NavBarItem(label: String, href: js.UndefOr[String] = "", target: js.UndefOr[String] = "", children: List[NavBarItem] = Nil) {
    def render(id: String, selected: String): TagMod = {
      val idGen = new IDGenerator(id)
      if (children.isEmpty)
        <.li(^.classSet("active" -> (id == selected)), <.a(^.href := href, label))
      else {
        <.li(^.cls := "dropdown",
          <.a(^.href := "#", ^.cls := "dropdown-toggle", Attr("data-toggle") := "dropdown",
            ^.role := "button", ^.aria.expanded := "false", label, <.span(^.cls := "caret")),
          <.ul(^.cls := "dropdown-menu", ^.role := "menu", children.map(_.render(idGen.getId, selected))
          )

        )

      }
    }
  }

  case class State(navExpanded: Boolean = false, selectedKey: String = "")

  case class Props(items: List[NavBarItem] = Nil, rightItems: List[NavBarItem] = Nil, brand: ReactElement = null, className: String = "", bsClass: String = "navbar", bsSize: String = "",
                   id: String = "nav-bar",
                   bsStyle: String = "default", defaultNavExpanded: Boolean = true,
                   fixedBottom: Boolean = false, fixedTop: Boolean = false, fluid: Boolean = true,
                   searchForm: Boolean = true,
                   inverse: Boolean = false, navExpanded: Option[Boolean] = None, onToggle: (ReactEvent) => Unit = null,
                   role: String = "navigation", staticTop: Boolean = false, toggleButton: ReactElement = null,
                   toggleNavKey: Any = null) extends BoostrapMixinProps

  def apply(items: List[NavBarItem] = Nil, rightItems: List[NavBarItem] = Nil,
            brand: ReactElement = null, className: String = "", bsClass: String = "navbar", bsSize: String = "",
            bsStyle: String = "default", defaultNavExpanded: Boolean = false,
            fixedBottom: Boolean = false, fixedTop: Boolean = false, fluid: Boolean = false,
            searchForm: Boolean = true,
            inverse: Boolean = false, navExpanded: Option[Boolean] = None, onToggle: (ReactEvent) => Unit = null,
            role: String = "navigation", staticTop: Boolean = false, toggleButton: ReactElement = null,
            toggleNavKey: Any = null,
            ref: js.UndefOr[String] = "", key: js.Any = {}) =
    component.set(key, ref)(Props(items = items, rightItems = rightItems, brand = brand, className = className, bsClass = bsClass, bsSize = bsSize,
      bsStyle = bsStyle, defaultNavExpanded = defaultNavExpanded,
      fixedBottom = fixedBottom, fixedTop = fixedTop, fluid = fluid, searchForm = searchForm,
      inverse = inverse, navExpanded = navExpanded, onToggle = onToggle,
      role = role, staticTop = staticTop, toggleButton = toggleButton, toggleNavKey = toggleNavKey))


  class Backend(t: BackendScope[Props, State]) {
    var isChanging = true

    def handleToggle(event: ReactEvent): Unit = {
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
      (P, S, B) => {

        implicit val idGenerator = new IDGenerator(P.id)

        def isNavExpanded: Boolean = if (P.navExpanded.isDefined) P.navExpanded.get else S.navExpanded

        def renderHeader: ReactElement = {
          val brand: TagMod =
            if (P.brand != null) {
              if (React.isValidElement(P.brand))
                ReactCloneWithProps(P.brand, Map("class" -> "navbar-brand"))
              else
                <.span(^.className := "navbar-brand", P.brand)
            } else EmptyTag
          <.div(^.className := "navbar-header", brand, if (P.toggleButton != null || P.toggleNavKey != null) renderToggleButton else EmptyTag)
        }


        def renderToggleButton: ReactElement = {
          if (React.isValidElement(P.toggleButton)) {
            ReactCloneWithProps(P.toggleButton, Map("className" -> "navbar-toggle"
              //TODO restore
              //              ,
              //              "onClick" -> BootStrapFunctionUtils.createChainedFunction(B.handleToggle , ((P.toggleButton.asInstanceOf[js.Dynamic].props).onClick).asInstanceOf[(ReactEvent) => Unit])
            ))
          }
          val children: List[TagMod] = if (P.toggleButton != null) List(P.toggleButton)
          else List(
            <.span(^.className := "sr-only", ^.key := 0, "Toggle navigation"),
            <.span(^.className := "icon-bar", ^.key := 1),
            <.span(^.className := "icon-bar", ^.key := 2),
            <.span(^.className := "icon-bar", ^.key := 3))

          <.button(^.className := "navbar-toggle", ^.tpe := "button", ^.onClick ==> B.handleToggle, children)
        }

        //        def renderChild(child: ReactNode, index: Int): ReactElement = {
        //          val dchild = child.asInstanceOf[js.Dynamic]
        //          val key: Any = if (child.hasOwnProperty("key") && dchild.key != null) dchild.key else index
        //          val props: Map[String, Any] = Map(
        //            "navbar" -> true,
        //            "collapsable" -> (P.toggleNavKey != null && P.toggleNavKey == dchild.props.eventKey),
        //            "expanded" -> (P.toggleNavKey != null && P.toggleNavKey == dchild.props.eventKey && isNavExpanded),
        //            "key" -> key,
        //            "ref" -> child.asInstanceOf[js.Dynamic].ref
        //          )
        //
        //
        //          val obj = ReactCloneWithProps(child, props.asInstanceOf[Map[String, js.Any]])
        //          println(s"NavBar ${child} $obj")
        //          obj
        //        }

        def searchForm: TagMod = {
          if (!P.searchForm) return EmptyTag
          <.form(^.cls := "navbar-form navbar-left", ^.role := "search",
            <.div(^.cls := "form-group",
              <.input(^.tpe := "text", ^.cls := "form-control", ^.placeholder := "Search")
            ),

            <.button(^.tpe := "submit", ^.cls := "btn btn-default", "Submit")
          )

        }

        val classes = P.getBsClassSet ++ Map(
          "navbar-fixed-top" -> P.fixedTop,
          "navbar-fixed-bottom" -> P.fixedBottom,
          "navbar-static-top" -> P.staticTop,
          "navbar-inverse" -> P.inverse)



        val header: TagMod = if (P.brand != null || P.toggleButton != null || P.toggleNavKey != null) renderHeader else EmptyTag
        <.nav(^.classSet1M(P.className, classes), ^.role := P.role,
          <.div(^.className := (if (P.fluid) "container-fluid" else "container"),
            header,
            <.div(^.cls := "collapse navbar-collapse",
              <.ul(^.cls := "nav navbar-nav", P.items.map(_.render(idGenerator.getId, S.selectedKey))),
              searchForm,
              <.ul(^.cls := "nav navbar-nav navbar-right", P.rightItems.map(_.render(idGenerator.getId, S.selectedKey))))
          )
        )
      }

    )
    //    .shouldComponentUpdate((scope, nextP, nextS) => {
    //    !scope.backend.isChanging
    //  })
    //    .configure(LogLifecycle.verbose)
    .build


}
