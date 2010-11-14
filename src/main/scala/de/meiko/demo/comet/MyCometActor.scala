package de.meiko.demo.comet

import _root_.net.liftweb.http.{ CometActor, S }
import _root_.net.liftweb.common.Loggable
import _root_.net.liftweb.widgets.autocomplete.AutoComplete

class MyCometActor extends CometActor with Loggable {

  def render = {

    bind("demo",
      "autoselect" -> AutoComplete("",
        (q: String, limit: Int) => {
          logger.debug(q)
          logger.debug(S.param("q"))
          1 to 5 map (_ + q)
        },
        (_) => {}))
  }
}