package scanner

import scala.concurrent._
import scala.concurrent.duration._

import upickle.default._

import RankImplicits._

object Main extends App {
  val client = new DatabinderMeetupClient
  val groups = Await.result(client.groups("Scala"), 10.seconds)
  println(write(groups.ranked.map(_.value)))
}