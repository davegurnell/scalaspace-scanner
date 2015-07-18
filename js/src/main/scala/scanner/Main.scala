package scanner

import scala.scalajs._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import org.scalajs.dom.ext._

import scala.concurrent._
import scala.concurrent.duration._

import upickle.default._

import RankImplicits._

object Main extends js.JSApp {
  def main(): Unit = {
    // val client = new DatabinderMeetupClient

    Ajax.get("https://api.meetup.com/find/groups?key=1e7567444f71b28447db5b1211d60&text=Scala&radius=global&sign=true").onSuccess{ case xhr =>
      val json = js.JSON.parse(xhr.responseText).asInstanceOf[String]

      val groups = read[Seq[MeetupGroup]](json)

      println(write(groups.ranked.map(_.value)))
    }
  }
}