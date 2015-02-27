package example.routes


import example.pages._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.{BaseUrl, Redirect, RoutingRules}
import org.scalajs.dom
import japgolly.scalajs.react.vdom.prefix_<^._
import sjs.react.bootstrap._

/**
 * Created by chandrasekharkode .
 */
object AppRouter {


  object AppPage extends RoutingRules {
    val root = register(rootLocation(HomePage()))

    register(removeTrailingSlashes)

    def currentRoute = dom.window.location.href.substring(baseUrl.value.length)

    override protected val notFound = redirect(root, Redirect.Replace)


    override protected def interceptRender(i: InterceptionR): ReactElement = {
      <.div(
        Navbar()(
          Nav()(
//                  <.div("Prova")
            NavItem(eventKey=1, href="#")("Link"),
            NavItem(eventKey=2, href="#")("Link")
//            ,
//            DropdownButton(eventKey=3, title="Dropdown")(
//              MenuItem(eventKey="1")("Action"),
//              MenuItem(eventKey="2")("Another action"),
//              MenuItem(eventKey="3")("Something else here"),
//              MenuItem(divider=true)(),
//              MenuItem(eventKey="4")("Separated link"),
//            )

          )
        ),
        i.element,
        <.div(^.textAlign := "center", ^.key := "footer")(
          <.hr(),
          <.p("Built using scalajs-react")
        )
      )
    }


    def getTitle(loc: String) = {
      if (loc.contains("materialui")) "Material-UI"
      else if (loc.contains("reacttable")) "React Table"
      else ""
    }


  }

  case class State(selectedIndex: Long)

  class Backend(t: BackendScope[_, _]) {


  }


//  val baseUrl = BaseUrl.fromWindowOrigin / "scalajs-react-components/demo/"
  val baseUrl = BaseUrl.fromWindowOrigin / "#"
  val C = AppPage.router(baseUrl)

}
