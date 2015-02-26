package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
active:   React.PropTypes.bool,
    disabled: React.PropTypes.bool,
    block:    React.PropTypes.bool,
    navItem:    React.PropTypes.bool,
    navDropdown: React.PropTypes.bool,
    componentClass: React.PropTypes.node,
    href: React.PropTypes.string,
    target: React.PropTypes.string
  */
object Button {


  case class State()

  class Backend(t: BackendScope[Props, State]) {

    def onClick(event: ReactEvent) {
      if(t.props.onClick!=null)
        t.props.onClick(event)
    }
  }



  //  val theToolTipRef = Ref.to(MuiTooltip.component, "theToolTipRef")
  val component = ReactComponentB[Props]("Button")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    var classes: Map[String, Boolean] = if (P.navDropdown) Map() else P.getBsClassSet

    classes +=("active" -> P.active, "btn-block" -> P.block)

    def renderAnchor(classes: Map[String, Boolean]) = {
      val comp = if (P.componentClass != null) P.componentClass else <.a
      val href = P.href.getOrElse("#")
      var cClasses = classes + ("disabled" -> P.disabled)
      if (P.className.nonEmpty)
        cClasses += (P.className.get -> true)

      <.a(^.href := href, ^.classSetM(cClasses), ^.role := "button", ^.onClick ==> B.onClick, C)
    }

    def renderButton(classes: Map[String, Boolean]) = {
      val comp = if (P.componentClass != null) P.componentClass else <.a
      val href = P.href.getOrElse("#")
      var cClasses = classes + ("disabled" -> P.disabled)
      if (P.className.nonEmpty)
        cClasses += (P.className.get -> true)
      println(s"adding ${P.onClick}")
      <.button(^.classSetM(cClasses), ^.href := href, ^.onClick ==>  B.onClick, C)
    }

    def renderNavItem(classes: Map[String, Boolean]) = {
      <.li(^.classSet("active" -> P.active), renderAnchor(classes))
    }

    if (P.navItem) {
      renderNavItem(classes)
    } else if (P.href.nonEmpty || P.target.nonEmpty || P.navDropdown) {
      renderAnchor(classes)
    } else {
      renderButton(classes)
    }
  }
    )
    .build


  case class Props(active: Boolean,
                   disabled: Boolean,
                   block: Boolean,
                   navItem: Boolean,
                   navDropdown: Boolean,
                   componentClass: ReactNode,
                   pullRight: Boolean=false,
                   dropup: Boolean=false,

                   href: js.UndefOr[String]=js.undefined,
                   target: js.UndefOr[String]=js.undefined,
                   className: js.UndefOr[String]=js.undefined,
                   title: js.UndefOr[String]=js.undefined,
                   onClick: (ReactEvent) => Unit = null,
                   bsClass: String = "btn", bsStyle: String = "default", bsSize: String = ""
                   //                   ,ref: js.UndefOr[String], key: js.Any
                    ) extends BoostrapMixinProps

  def apply(active: Boolean=false,
            disabled: Boolean=false,
            block: Boolean=false,
            navItem: Boolean=false,
            navDropdown: Boolean=false,
            pullRight: Boolean=false,
            dropup: Boolean=false,
            componentClass: ReactNode = null,
            onClick: (ReactEvent) => Unit = null,
            href: js.UndefOr[String]=js.undefined,
            target: js.UndefOr[String]=js.undefined,
            title: js.UndefOr[String]=js.undefined,
            className:js.UndefOr[String]=js.undefined,
            bsClass: String = "btn", bsStyle: String = "default", bsSize: String = "",
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(active = active, disabled = disabled, block = block,
      navItem = navItem, navDropdown = navDropdown, pullRight=pullRight, dropup=dropup,
      componentClass = componentClass, href = href, target = target, className = className,
      onClick=onClick, title=title,
      bsClass = bsClass, bsStyle = bsStyle, bsSize = bsSize
    ), children)
  }

  //  case class Props(
  //                    iconClassName: String, onBlur: REventIUnit, touch: Boolean, url: String, clsNames: CssClassType,

  //                   onMouseOver: REventIUnit, linkButton: Boolean, onTouchTap: REventIUnit,
  //                   className: String, onMouseOut: REventIUnit, onFocus: REventIUnit, disabled: Boolean, tooltip: String) extends BoostrapMixinProps

  /**
  active:   React.PropTypes.bool,
    disabled: React.PropTypes.bool,
    block:    React.PropTypes.bool,
    navItem:    React.PropTypes.bool,
    navDropdown: React.PropTypes.bool,
    componentClass: React.PropTypes.node,
    href: React.PropTypes.string,
    target: React.PropTypes.string
    */

}
