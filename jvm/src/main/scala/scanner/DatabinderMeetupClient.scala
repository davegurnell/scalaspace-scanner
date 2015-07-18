package scanner

// import scala.concurrent._
// import scala.concurrent.duration._

import upickle.default._

import dispatch._
import dispatch.Defaults._

class DatabinderMeetupClient extends MeetupClient {

  def groups(keyword: String): Future[Seq[MeetupGroup]] = {
    val svc = url("https://api.meetup.com/find/groups?key=1e7567444f71b28447db5b1211d60&text=Scala&radius=global&sign=true")

    val data: Future[String] = Http(svc OK as.String)

    data.map(read[Seq[MeetupGroup]](_))
  }
}
