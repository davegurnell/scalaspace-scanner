// package scanner

// import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
// import scala.scalajs.dom.ext._

// import scala.concurrent._
// import scala.concurrent.duration._

// import upickle.default._

// // import org.scalajs.jquery.jQuery

// class JQueryMeetupClient extends MeetupClient {
//   def groups(keyword: String): Future[Seq[MeetupGroup]] = {
//     val data: Future[String] = jQuery.get("https://api.meetup.com/find/groups?key=1e7567444f71b28447db5b1211d60&text=Scala&radius=global&sign=true")

//     data.map(read[Seq[MeetupGroup]](_))
//   }
// }
