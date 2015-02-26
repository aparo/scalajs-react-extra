package example.routes


import example.pages._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.{BaseUrl, Redirect, RoutingRules}
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom

/**
 * Created by chandrasekharkode .
 */
object AppRouter {


  object AppPage extends RoutingRules {
    val root = register(rootLocation(HomePage()))
//    val minfo: Loc = register(location("#materialui/info", MaterialUIPage(MInfo())))
//    val mbuttons: Loc = register(location("#materialui/buttons", MaterialUIPage(MuiButtonsDemo())))
//    val mdialog: Loc = register(location("#materialui/dialog", MaterialUIPage(MuiDialogDemo())))
//    val mdropdown: Loc = register(location("#materialui/dropdown", MaterialUIPage(MuiDropdownMenuDemo())))
//    val miconbuttons: Loc = register(location("#materialui/iconbuttons", MaterialUIPage(MuiIconButtonsDemo())))
//    val minputs: Loc = register(location("#materialui/inputs", MaterialUIPage(MInputs())))
//    val mtextFields: Loc = register(location("#materialui/textfields", MaterialUIPage(MuiTextFieldDemo())))
//    val mleftnav: Loc = register(location("#materialui/leftnav", MaterialUIPage(MuiLeftNavDemo())))
//    val mmenus: Loc = register(location("#materialui/menus", MaterialUIPage(MuiMenuDemo())))
//    val mpaper: Loc = register(location("#materialui/paper", MaterialUIPage(MuiPaperDemo())))
//    val mswitches: Loc = register(location("#materialui/switches", MaterialUIPage(MuiSwitchesDemo())))
//    val mtoast: Loc = register(location("#materialui/toast", MaterialUIPage(MToast())))
//    val mtoolbar: Loc = register(location("#materialui/toolbar", MaterialUIPage(MuiToolbarDemo())))
//    val mdatepicker: Loc = register(location("#materialui/datepicker", MaterialUIPage(MuiDatePickerDemo())))
//
//    // react table routes
//    val reacttable: Loc = register(location("#reacttable/info", ReactTablePage(ReactTableInfo())))
//    val reactbasic: Loc = register(location("#reacttable/basic", ReactTablePage(BasicReactTable())))
//    val reactsort: Loc = register(location("#reacttable/sort", ReactTablePage(SortingReactTable())))
//    val reactcustomcell: Loc = register(location("#reacttable/customcell", ReactTablePage(CustomCellReactTable())))
//    val reactcustomcss: Loc = register(location("#reacttable/customcss", ReactTablePage(CustomCssReactTable())))




    register(removeTrailingSlashes)

    def currentRoute = dom.window.location.href.substring(baseUrl.value.length)

    override protected val notFound = redirect(root, Redirect.Replace)


    override protected def interceptRender(i: InterceptionR): ReactElement = {
      div(
//        AppHeader(),
        i.element,
        div(textAlign := "center", key := "footer")(
          hr(),
          p("Built using scalajs-react")
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
