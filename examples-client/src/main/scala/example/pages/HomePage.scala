package example.pages

import example.components.{TabbedJSONViewer, JSONViewer}
import sjs.FontAwesome
import sjs.react.bootstrap.Button
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js.JSON

object HomePage {

  val jsonSample=
    """
      |{
      |    "glossary": {
      |        "title": "example glossary",
      |		"GlossDiv": {
      |            "title": "S",
      |			"GlossList": {
      |                "GlossEntry": {
      |                    "ID": "SGML",
      |					"SortAs": "SGML",
      |					"GlossTerm": "Standard Generalized Markup Language",
      |					"Acronym": "SGML",
      |					"Abbrev": "ISO 8879:1986",
      |					"GlossDef": {
      |                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
      |						"GlossSeeAlso": ["GML", "XML"]
      |                    },
      |					"GlossSee": "markup"
      |                }
      |            }
      |        }
      |    }
      |}
    """.stripMargin

  case class State()

  class Backend(t: BackendScope[_, State]) {

    def onTextChange(text: String) = {
      //      val results = Components.all.filter(c => c.tags.exists(s => s.contains(text)))
      //      t.modState(_.copy(results = results, filterText = text))
    }

    def onClick(event: ReactEvent = null): Unit = {
      println("clicked")
    }
  }

  val component = ReactComponentB[Unit]("homepage")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(
      <.div(^.key := "info")(
        Button(title = "Prova", onClick = B.onClick)("Prova"),
        <.button(^.onClick --> B.onClick(), FontAwesome.anchor, "Prova")
      )
//      ,TabbedJSONViewer(JSON.parse(jsonSample))
//    ,JSONViewer(JSON.parse(jsonSample))
    )
  })
    .buildU


  def apply() = component()

}
