/*
 * Copyright (c) 2016 - Alberto Paro All Rights Reserved.
 */

package io.megl.web.utils

import org.scalajs.dom

object CookieService {

  def getCookies(): Map[String, String] = {
    dom.document.cookie.split(';').map {
      v =>
        val pos = v.indexOf("=")
        (v.slice(0, pos) -> v.slice(pos + 1, v.length))
    }.toMap
  }

  def get(name: String) = getCookies().get(name)
}
