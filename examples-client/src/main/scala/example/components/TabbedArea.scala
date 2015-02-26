package example.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object TabbedArea {

  case class PanelModel(tabName: String, children: List[ReactElement],
                        classes: Map[String, Boolean] = Map.empty[String, Boolean]
                         )

  case class State(activeKey: Int = 0)

  class Backend(t: BackendScope[Props, State]) {

    def handleClick(key: Int, event: ReactEvent) {
      println(s"TabbedArea clicked (${key}})")

      event.preventDefault()
      t.modState(_.copy(activeKey = key))
    }
  }

  val component = ReactComponentB[Props]("TabbedArea2")
    .initialStateP(P => {
    State(activeKey = P.activeTab)
  })
    .backend(new Backend(_))
    .render(
      (P, S, B) => {

        def renderTabs = {
          P.panelModels.zipWithIndex.map {
            case (item, idx) =>
              Tab(key = idx, name = item.tabName, onClick = B.handleClick, isActive = (idx == S.activeKey))
          }
        }

        def renderPanes = {
          P.panelModels.zipWithIndex.map {
            case (item, idx) =>
              val panelClasses = item.classes ++ Map("tab-pane" -> true, "active" -> (idx == S.activeKey))
              <.div(^.key := idx, ^.classSetM(panelClasses), item.children)
          }
        }

        <.div(
          <.ul(^.className := "nav nav-pills nav-justified", renderTabs),
          <.div(^.className := "tab-content", renderPanes)
        )
      }
    )
    .build


  case class Props(panelModels: List[PanelModel], activeTab: Int = 0)

  def apply(panelModels: List[PanelModel],
            activeTab: Int = 0, ref: js.UndefOr[String] = "",
            key: js.Any = {}) = {
    component.set(key, ref)(Props(panelModels = panelModels,
      activeTab = activeTab))
  }

}
