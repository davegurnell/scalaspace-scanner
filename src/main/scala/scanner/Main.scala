package scanner

import dispatch._
import dispatch.Defaults._

import scala.concurrent._
import scala.concurrent.duration._

import upickle.default._

object Main extends App {
  val svc = url("https://api.meetup.com/find/groups?key=1e7567444f71b28447db5b1211d60&text=Scala&radius=global&sign=true")

  val json: String = Await.result(Http(svc OK as.String), 10.seconds)

  val groups = read[Seq[MeetupGroup]](json)

  def count(str: String): Int = str.split(" ").toList.count(w => w.toLowerCase.contains("scala"))

  val stats = groups.map { g =>
    GroupStats(g, count(g.description) + count(g.name))
  }

  stats.foreach(println)
}