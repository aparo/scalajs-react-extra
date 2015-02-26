
package sjs.react.bootstrap

import japgolly.scalajs.react._
import org.scalajs.dom

import scala.scalajs.js
import japgolly.scalajs.react.vdom.prefix_<^._


object Modal /* mixins: BootstrapMixin with FadeMixin*/ {

  case class Props(onRequestHide: (ReactEvent) => Unit, animation: Boolean = true, backdrop: Boolean = true,
                   bsClass: String = "modal", bsSize: String = "", bsStyle: String = "", className: String = "",
                   closeButton: Boolean = true, keyboard: Boolean = true, title: ReactElement = null) extends BoostrapMixinProps

  def apply(onRequestHide: (ReactEvent) => Unit, animation: Boolean = true, backdrop: Boolean = true,
            bsClass: String = "modal", bsSize: String = "", bsStyle: String = "", className: String = "",
            closeButton: Boolean = true, keyboard: Boolean = true, title: ReactElement = null,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(onRequestHide = onRequestHide, animation = animation, backdrop = backdrop,
      bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle,
      closeButton = closeButton, keyboard = keyboard, title = title, className = className), children)
  }

  case class State()

  class Backend(t: BackendScope[Props, State]) {

    def onRequestHide(event: ReactEvent): Unit = {

    }

    def handleBackdropClick(e: ReactEvent): Unit = {
      if (e.target != e.currentTarget) {
        return
      }
      t.props.onRequestHide(e)
    }

    def handleDocumentKeyUp(e: ReactKeyboardEvent) {
      if (t.props.keyboard && e.key(0) == 27) {
        t.props.onRequestHide(e)
      }
    }

    def iosClickHack() {
      t.refs("modal").asInstanceOf[js.Dynamic].getDOMNode().onclick = {}
      t.refs("backdrop").asInstanceOf[js.Dynamic].getDOMNode().onclick = {}
    }

  }

  val component = ReactComponentB[Props]("Modal")
    .initialState(State())
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {


        def renderTitle: ReactElement = {
          if (React.isValidElement(P.title) && P.title != null)
            <.h4(^.className := "modal-title", P.title)
          else null
        }


        def renderHeader: ReactElement = {
          val closeButton =
            if (P.closeButton) {
              <.button(^.tpe := "button", ^.className := "close", ^.aria.hidden := "true", ^.onClick ==> B.onRequestHide, "\u00d7")
            } else null
          <.div(^.className := "modal-header", closeButton, renderTitle)
        }


        def renderBackdrop(modal: ReactElement): ReactElement = {
          val classes = Map("modal-backdrop" -> true, "fade" -> P.animation,
            "in" -> (!P.animation /*|| !document.querySelectorAll*/))
          <.div(<.div(^.classSetM(classes), ^.ref := "backdrop", ^.onClick ==> B.handleBackdropClick), modal)
        }

        val modalStyle = Map("display" -> "block")
        var dialogClasses = P.getBsClassSet
        dialogClasses -= "modal"
        dialogClasses += ("modal-dialog" -> true)

        val handleBackdropClick: (ReactEvent) => Unit = if (P.backdrop) B.handleBackdropClick else null

        val classes = Map("modal" -> true, "fade" -> P.animation, "in" -> (!P.animation /*|| !dom.document.querySelectorAll*/))
        val modal = <.div(^.tabIndex := "-1", ^.role := "dialog", ^.style := "display:block",
          ^.classSet1M(P.className, classes), ^.onClick ==> handleBackdropClick,
          ^.ref := "modal", <.div(^.classSetM(dialogClasses),
            <.div(^.className := "modal-content", if (P.title != null) renderHeader else null, C)))



        if (P.backdrop) renderBackdrop(modal) else modal
      }
    ).componentDidMount(
      scope => {
        /*
        *       this._onDocumentKeyupListener = EventListener.listen(document, "keyup", this.handleDocumentKeyUp)
              var container = (P.container && P.container.getDOMNode()) || document.body
              container.className += container.className.length ? " modal-open" : "modal-open"
              if (P.backdrop)
              {
                this.iosClickHack()
              }

        * */
      }
    ).componentDidUpdate(
      (scope, prevProps, prevS) => {
        if (scope.props.backdrop && scope.props.backdrop != prevProps.backdrop) {
          scope.backend.iosClickHack()
        }
      }
    )
    .build
  /*
  */
  /*
    def componentWillUnmount(
      function() {
        this._onDocumentKeyupListener.remove()
        var container = (P.container && P.container.getDOMNode()) || document.body
        container.className = container.className.replace(/ ?modal-open/, "")
      }
    )
  */
  /*
  */

}
