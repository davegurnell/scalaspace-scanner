package scanner

import dispatch._
import dispatch.Defaults._

import scala.concurrent._
import scala.concurrent.duration._

import upickle.default._

import RankImplicits._

object Main extends App {
  val badKeywords = Seq(
    "clojure"
  )

  val svc = url("https://api.meetup.com/find/groups?key=1e7567444f71b28447db5b1211d60&text=Scala&radius=global&sign=true")

  val json: String = Await.result(Http(svc OK as.String), 10.seconds)

  val groups = read[Seq[MeetupGroup]](json)

  val stats = groups.ranked

  println(write(stats.map(_.value)))
}