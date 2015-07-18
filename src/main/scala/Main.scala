import dispatch._
import dispatch.Defaults._

import scala.concurrent._
import scala.concurrent.duration._

import upickle._
import upickle.default._

object Main extends App {
  val svc = url("https://api.meetup.com/find/groups?key=1e7567444f71b28447db5b1211d60&country=uk&sign=true")

  val json: String = Await.result(Http(svc OK as.String), 1.seconds)

  val jsValue: Js.Value = upickle.json.read(json)

  println(jsValue)
}