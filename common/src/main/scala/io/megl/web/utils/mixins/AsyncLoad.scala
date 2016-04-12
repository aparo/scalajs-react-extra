/*
 * Copyright (c) 2016 - Alberto Paro All Rights Reserved.
 */

package io.megl.web.utils.mixins

import japgolly.scalajs.react.{Callback, ReactComponentB}
import org.scalajs.dom
import org.scalajs.dom.ext.PimpedNodeList

/***
 * To load resources(javascript,stylesheet) on fly
 */
trait AsyncLoad {

  var jsResources: List[String] = List()

  var cssResources: List[String] = List()

}

object AsyncLoad {
  def mixin[P, S, B, N <: japgolly.scalajs.react.TopNode] = (c: ReactComponentB[P, S, B, N]) => {
    c.componentWillMount(scope => Callback {
      val async = scope.backend.asInstanceOf[AsyncLoad]
      async.cssResources.foreach(s => {
        val head =   dom.document.head
        val link = dom.document.createElement("link")
        link.setAttribute("rel","stylesheet")
        link.setAttribute("href",s)
        val links = dom.document.getElementsByTagName("link")
        if(!links.contains(link)) head.appendChild(link)
      })
      async.jsResources.foreach(s => {
        val body = dom.document.body
        val script = dom.document.createElement("script")
        script.setAttribute("type","text/javascript")
        script.setAttribute("src",s)
        val scripts = dom.document.getElementsByTagName("src")
        if(!scripts.contains(script)) body.appendChild(script)
      })
    })
  }
}
