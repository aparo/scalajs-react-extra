package example

import example.routes.AppRouter
import japgolly.scalajs.react.React

import scala.scalajs.js
import org.scalajs.dom
import shared.SharedMessages

object ScalaJSExample extends js.JSApp {
  def main(): Unit = {
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks

    React.render(AppRouter.C(), dom.document.getElementById("container"))
  }
}
