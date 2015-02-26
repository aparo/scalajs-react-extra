package example.components

import japgolly.scalajs.react.{BackendScope, ReactEvent, ReactComponentB}
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object Tab {

  case class State()

  class Backend(t: BackendScope[Props, State]) {

    def onClick(event: ReactEvent) {
      t.props.onClick(t.props.key,event)
    }
  }

  val component = ReactComponentB[Props]("Tab")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
      <.li(^.classSet("active" -> P.isActive), ^.onClick ==> B.onClick,
        <.a(^.href :="#", P.name)
      )
  }
    )
    .build


  case class Props(name:String, onClick:(Int, ReactEvent)=>Unit, key:Int, isActive: Boolean=false)

  def apply(name:String, onClick:(Int, ReactEvent)=>Unit, isActive: Boolean=false,
            ref: js.UndefOr[String] = "", key: js.Any = {}) = {
    component.set(key, ref)(Props(name=name, onClick = onClick,isActive=isActive,
      key=key.asInstanceOf[Int]))
  }
}
