
package sjs.react.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


object Input {

  case class State()

  class Backend(t: BackendScope[Props, State]) {
  }

  val component = ReactComponentB[Props]("Input")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, C, S, B) => {

    def isCheckboxOrRadio: Boolean = P.`type` == "radio" || P.`type` == "checkbox"

    def renderCheckboxandRadioWrapper(children: ReactNode*) = {
      val classes = Map("checkbox" -> (P.`type` == "checkbox"), "radio" -> (P.`type` == "radio"))
      <.div(^.classSetM(classes), ^.key := "checkboxRadioWrapper", children)
    }

    def renderLabel(children: ReactNode*): Seq[ReactNode] = {
      var classes = Map("control-label" -> !isCheckboxOrRadio)
      if (P.labelClassName.nonEmpty)
        classes += (P.labelClassName -> true)
      if (P.label != null)
        Seq(<.label(^.htmlFor := P.id, ^.classSetM(classes), ^.key := "label", children, P.label))
      else
        children
    }

    def renderWrapper(children: ReactNode*): Seq[ReactNode] = {
      if (P.wrapperClassName.nonEmpty)
        Seq(<.div(^.className := P.wrapperClassName, ^.key := "wrapper", children))
      else children
    }

    def renderIcon: ReactNode = {
      val classes = Map("glyphicon" -> true, "form-control-feedback" -> true, "glyphicon-ok" -> (P.bsStyle == "success"),
        "glyphicon-warning-sign" -> (P.bsStyle == "warning"), "glyphicon-remove" -> (P.bsStyle == "error"))
      if (P.hasFeedback) <.span(^.classSetM(classes), ^.key := "icon") else null
    }

    def renderFormGroup(children: ReactNode*) = {
      var classes = Map("form-group" -> true, "has-feedback" -> P.hasFeedback, "has-success" -> (P.bsStyle == "success"),
        "has-warning" -> (P.bsStyle == "warning"), "has-error" -> (P.bsStyle == "error"),
        P.groupClassName -> P.groupClassName.nonEmpty)


      <.div(^.classSetM(classes), children)
    }


    def renderHelp: ReactNode = {
      if (P.help != null) <.span(^.className := "help-block", ^.key := "help", P.help)
      else null
    }

    def isFile = P.`type` == "file"

    def renderInputGroup(children: ReactNode*): Seq[ReactNode] = {
      val addonBefore: ReactElement = if (P.addonBefore != null) <.span(^.className := "input-group-addon", ^.key := "addonBefore", P.addonBefore) else null
      val addonAfter: ReactElement = if (P.addonAfter != null) <.span(^.className := "input-group-addon", ^.key := "addonAfter", P.addonAfter) else null
      val buttonBefore: ReactElement = if (P.buttonBefore != null) <.span(^.className := "input-group-btn", P.buttonBefore) else null
      val buttonAfter: ReactElement = if (P.buttonAfter != null) <.span(^.className := "input-group-btn", P.buttonAfter) else null
      if (addonBefore != null || addonAfter != null || buttonBefore != null || buttonAfter != null)
        Seq(<.div(^.className := "input-group", ^.key := "input-group", addonBefore, buttonBefore, children, addonAfter, buttonAfter))
      else
        children
    }

    def renderInput: ReactNode = {

      if (P.`type`.isEmpty) {
        return C
      }
      P.`type` match {
        case "select" =>
          <.select(^.className := BootStrapFunctionUtils.joinClasses(P.className, "form-control"), ^.ref := "input", ^.key := "input", C)
        case "textarea" =>
          <.textarea(^.className := BootStrapFunctionUtils.joinClasses(P.className, "form-control"), ^.ref := "input", ^.key := "input")
        case "static" =>
          <.p(^.className := BootStrapFunctionUtils.joinClasses(P.className, "form-control-static"), ^.ref := "input", ^.key := "input", P.value)
        case "submit" =>
          Button(componentClass = "input", ref = "input", key = "input")()
        case _ =>
          var className = if (isCheckboxOrRadio || isFile) "" else "form-control"
          <.input(^.className := BootStrapFunctionUtils.joinClasses(P.className, className), ^.ref := "input", ^.key := "input")
      }
    }



    if (isCheckboxOrRadio) {
      renderFormGroup(renderWrapper(renderCheckboxandRadioWrapper(renderLabel(renderInput)), renderHelp))
    } else {
      renderFormGroup(renderLabel(), renderWrapper(renderInputGroup(renderInput), renderIcon, renderHelp))
    }
  }
    )
    .build

  /*
  */
  /*
  */
  /*
  */
  /*
    def getChecked(
      function() {
        return this.getInputDOMNode().checked
      }
    )
  */
  /*
  */
  /*

  */
  /*
    def getValue(
      function() {
        if (P.`type` === "static")
        {
          return P.value
        } else if (P.`type`)
        {
          if (P.`type` == "select" && P.multiple)
          {
            return this.getSelectedOptions()
          } else {
            return this.getInputDOMNode().value
          }
        } else {
          throw Error("Cannot use getValue without specifying input type.")
        }
      }
    )
  */
  /*
    def getSelectedOptions(
      function() {
        var values = []
        Array.prototype.forEach.call(this.getInputDOMNode().getElementsByTagName("option"), function(option) {
    if (option.selected)
    {
      var value = option.getAttribute("value") || option.innerHTML
      values.push(value)
    }
  })
        return values
      }
    )
  */
  /*
  */
  /*
    def getInputDOMNode(
      function() {
        return this.refs.input.getDOMNode()
      }
    )
  */ case class Props(id: String = "", bsStyle: String="", addonAfter: ReactElement = null, addonBefore: ReactElement = null,
                    buttonAfter: ReactElement = null, buttonBefore: ReactElement = null, disabled: Boolean = false,
                    groupClassName: String = "", hasFeedback: Boolean = false, help: ReactElement = null,
                    label: ReactElement = null, labelClassName: String = "", `type`: String = "",
                    wrapperClassName: String = "", className: String = "", value: ReactElement = null,
                    bsSize: String = "", bsClass: String = "") extends BoostrapMixinProps

  def apply(id: String = "", bsStyle: String="", bsSize: String = "", bsClass: String = "", addonAfter: ReactElement = null, addonBefore: ReactElement = null,
            buttonAfter: ReactElement = null, buttonBefore: ReactElement = null, disabled: Boolean = false,
            groupClassName: String = "", hasFeedback: Boolean = false, help: ReactElement = null,
            label: ReactElement = null, labelClassName: String = "", `type`: String = "",
            wrapperClassName: String = "", value: ReactElement = null, className: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(id = id, bsStyle = bsStyle, addonAfter = addonAfter, addonBefore = addonBefore,
      buttonAfter = buttonAfter, buttonBefore = buttonBefore, disabled = disabled,
      groupClassName = groupClassName, hasFeedback = hasFeedback, help = help,
      label = label, labelClassName = labelClassName, `type` = `type`,
      wrapperClassName = wrapperClassName, className = className, value = value, bsSize = bsSize, bsClass = bsClass), children)
  }

}
