
package sjs.react.bootstrap

import japgolly.scalajs.react._

import scala.scalajs.js


object Accordion {


  val component = ReactComponentB[Unit]("Accordion")
    .render(
      (P, C) => {
        PanelGroup(accordion = true)(C)
      }
    )
    .build

  def apply(ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Unit, children)
  }

}
