package bootstrap.liftweb

import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.net.liftweb.http._
import _root_.net.liftweb.http.provider._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._
import _root_.net.liftweb.mapper.{ DB, ConnectionManager, Schemifier, DefaultConnectionIdentifier, StandardDBVendor }
import _root_.java.sql.{ Connection, DriverManager }
import _root_.net.liftweb.widgets.autocomplete._

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    LogBoot.defaultProps =
      """<?xml version="1.0" encoding="UTF-8" ?>
      <!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
      <log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
      <appender name="appender" class="org.apache.log4j.ConsoleAppender">
      <layout class="org.apache.log4j.SimpleLayout"/>
      </appender>
      <logger name="de.meiko.demo">
        <level value="DEBUG"/> 
      </logger>
      <root>
      <priority value ="WARN"/>
      <appender-ref ref="appender"/>
      </root>
      </log4j:configuration>
      """
    LiftRules.addToPackages("de.meiko.demo")
    AutoComplete.init
  }

}
