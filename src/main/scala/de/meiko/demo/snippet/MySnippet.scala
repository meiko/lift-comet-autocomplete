package de.meiko.demo.snippet

import _root_.net.liftweb.http.S
import _root_.net.liftweb.common.Loggable
import _root_.net.liftweb.util.Helpers._
import _root_.net.liftweb.widgets.autocomplete.AutoComplete
import _root_.scala.xml.NodeSeq


class MySnippet extends Loggable {
  
  def show(xhtml: NodeSeq) = {

    bind("snip", xhtml,
      "autoselect" -> AutoComplete("",
        (q: String, limit: Int) => {
          logger.debug(q)
          logger.debug(S.param("q"))
          1 to 5 map (_ + q)
        },
        (_) => {}))
  }
}