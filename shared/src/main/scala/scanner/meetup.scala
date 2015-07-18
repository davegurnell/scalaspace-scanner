package scanner

import scala.concurrent._
import scala.concurrent.duration._

import upickle.default._

trait MeetupClient {
  def groups(keyword: String): Future[Seq[MeetupGroup]]
}
