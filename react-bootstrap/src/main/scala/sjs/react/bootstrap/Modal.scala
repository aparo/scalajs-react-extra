
package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom._
import org.scalajs.dom.ext.KeyCode
import sjs.utils.Events
import sjs.utils.mixins.WindowListeners

import scala.scalajs.js


object Modal /* mixins: BootstrapMixin with FadeMixin*/ {


  trait Style {

    def displayBlock: TagMod = Seq(^.display := "block")
  }

  case class Props(body: ReactElement, onRequestHide: (ReactEvent) => Unit, animation: Boolean = true, backdrop: Boolean = false,
                   bsClass: String = "modal", bsSize: String = "", bsStyle: String = "", className: String = "",
                   closeButton: Boolean = true, keyboard: Boolean = true, title: ReactElement = null,
                   style: Style = new Style {})
    extends BoostrapMixinProps

  def apply(body: ReactElement, onRequestHide: (ReactEvent) => Unit, animation: Boolean = true, backdrop: Boolean = true,
            bsClass: String = "modal", bsSize: String = "", bsStyle: String = "", className: String = "",
            style: Style = new Style {},
            closeButton: Boolean = true, keyboard: Boolean = true, title: ReactElement = null,
            ref: js.UndefOr[String] = "", key: js.Any = {}) = {
    component.set(key, ref)(Props(body = body, onRequestHide = onRequestHide, animation = animation, backdrop = backdrop,
      bsClass = bsClass, bsSize = bsSize, bsStyle = bsStyle,
      closeButton = closeButton, keyboard = keyboard, title = title, className = className))
  }

  case class State(open: Boolean)

  class Backend(t: BackendScope[Props, State]) extends WindowListeners {

    //    def init(): Unit ={
    //      /*
    //*       this._onDocumentKeyupListener = EventListener.listen(document, "keyup", this.handleDocumentKeyUp)
    //      var container = (P.container && P.container.getDOMNode()) || document.body
    //      container.className += container.className.length ? " modal-open" : "modal-open"
    //      if (P.backdrop)
    //      {
    //        this.iosClickHack()
    //      }
    //
    //* */
    //
    //      onUnmount{
    ////        this._onDocumentKeyupListener.remove()
    //        var container = t.getDOMNode()
    //        if(container==null)
    //          container=dom.document.getElementsByTagName("body")(0).asInstanceOf[html.Element]
    //        container.className.replaceAll("\bmodal-open\b", "")
    //
    ////        var container = (t.props.container && t.props.container.getDOMNode()) || dom.document.body
    ////        container.className = container.className.replace(/ ?modal-open/, "")
    ////
    //      }
    //    }

    def dismiss(e: ReactEvent = null): Unit = {

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

    lazy val handleWindowKeyUp: js.Function1[Event, _] = (e: Event) => {
      if (e.asInstanceOf[KeyboardEvent].keyCode == KeyCode.escape) dismiss()
    }
    override val listeners: List[(String, js.Function1[Event, _])] = List((Events.KEYUP, handleWindowKeyUp))

  }

  val component = ReactComponentB[Props]("Modal")
    .initialState(State(true))
    .backend(new Backend(_))
    .render(
      (P, C, S, B) => {


        def renderTitle: TagMod = {
          if (React.isValidElement(P.title) && P.title != null)
            <.h4(^.className := "modal-title", P.title)
          else EmptyTag
        }


        def renderHeader: ReactElement = {
          val closeButton =
            if (P.closeButton) {
              <.button(^.tpe := "button", ^.className := "close", ^.aria.hidden := "true", ^.onClick ==> (B.dismiss _), "\u00d7")
            } else null
          <.div(^.className := "modal-header", closeButton, renderTitle)
        }

        def renderBody: ReactElement = {
          <.div(^.className := "modal-body", P.body)
        }

        def renderFooter: ReactElement = {
          <.div(^.className := "modal-footer", "TODO")
        }

        def renderBackdrop(modal: TagMod): ReactElement = {
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
        val modal = <.div(^.classSet1M(P.className, classes), ^.tabIndex := "-1",
          ^.role := "dialog", P.style.displayBlock,
          ^.onClick ==> handleBackdropClick,
          ^.ref := "modal",
          <.div(^.classSetM(dialogClasses),
            <.div(^.className := "modal-content", if (P.title != null) renderHeader else EmptyTag,
              renderBody, renderFooter)))



        if (P.backdrop) renderBackdrop(modal) else modal
      }
    ).componentDidUpdate(
      (scope, prevProps, prevS) => {
        if (scope.props.backdrop && scope.props.backdrop != prevProps.backdrop) {
          scope.backend.iosClickHack()
        }
      }
    )
    //    .componentWillMount(_.backend.init())
    //    .configure(OnUnmount.install)
    .configure(WindowListeners.mixin)
    .build

}
