package example.components

import example.components.TabbedArea.PanelModel
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactElement, ReactComponentB}

import scala.scalajs.js
import scala.scalajs.js.JSON

object TabbedJSONViewer {

  def jsonPrettyPrinter(data:js.Any):String={
    JSON.stringify(data, null.asInstanceOf[js.Array[js.Any]], 2)
      .replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
  }


  val component = ReactComponentB[Props]("TabbedJSONViewer")
    .render((P, C) => {
    val panels=List(

      PanelModel("JSON", List(<.pre(jsonPrettyPrinter(P.data)))),
      PanelModel("Table", List(JSONViewer(P.data)))
      )


    <.div("startTabbed",
      TabbedArea(panels),

//    TabbedArea(defaultActiveKey=1)(
//      TabPane(eventKey=1, tab="Tab1")(JSONViewer(P.data)),
//      TabPane(eventKey=2, tab="Tab2")("Prova content 2")
//    ),
      "endTabbed"
    )
  }
    )
    .build


  case class Props(data: js.Dynamic)

  def apply(data: js.Dynamic,
            ref: js.UndefOr[String] = "", key: js.Any = {}) = {
    component.set(key, ref)(Props(data = data))
  }

}
