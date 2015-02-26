package example.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import sjs.FontAwesome

import scala.scalajs.js

object JSONViewer {


  //  val theToolTipRef = Ref.to(MuiTooltip.component, "theToolTipRef")
  val component = ReactComponentB[Props]("JSONViewer")
    .render((P, C) => {
    def render(d: js.Any): ReactElement = {
      //      js.typeOf(d) match {
      //        case "object" =>
      //          <.dl(^.cls := "dl-horizontal",
      //            d.asInstanceOf[js.Dictionary[js.Any]].flatMap(v => List(<.dt(v._1), <.dd(render(v._2))))
      //          )
      //        case "array" =>
      //          <.ul(d.asInstanceOf[js.Array[js.Any]].map(v => <.li(render(v))))
      //        case "string" =>
      //          <.span(d.toString)
      //        case default =>
      //          println(s"Not processed $default")
      //          <.span(d.toString)
      //      }
      js.typeOf(d) match {
        case "object" =>
          val myDict = d.asInstanceOf[js.Dictionary[js.Any]]
          if (myDict.isEmpty)
            <.span("<EMPTY>")
          else {
            <.div(^.cls := "table-responsive",
              <.table(^.cls := "table table-bordered table-hover table-condensed",
                myDict.map(v => <.tr(<.td(v._1), <.td(render(v._2))))
              )
            )
          }
        case "array" =>
          <.ul(d.asInstanceOf[js.Array[js.Any]].map(v => <.li(render(v))))
        case "string" =>
          <.span(d.toString)
        case "boolean" =>
          val bool=d.asInstanceOf[Boolean]
          if (bool)
            <.span(^.cls := "success", FontAwesome.checkCircle, " "+ d.toString)
          else
            <.span(^.cls := "danger", FontAwesome.remove, " "+d.toString)
        case default =>
//          println(s"Not processed $default")
          <.span(d.toString)
      }

    }
    render(P.data)
  }
    )
    .build


  case class Props(data: js.Dynamic)

  def apply(data: js.Dynamic,
            ref: js.UndefOr[String] = "", key: js.Any = {}) = {
    component.set(key, ref)(Props(data = data))
  }

}
