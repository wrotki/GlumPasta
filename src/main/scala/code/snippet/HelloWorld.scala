package code 
package snippet

import net.liftweb.http.LiftRules

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> date.map(_.toString ++ " 2 hour")//date.map(_.toString)

  def foojs = LiftRules.getResource("/META-INF/resources/webjars/jquery/2.0.0/foo.js")

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

