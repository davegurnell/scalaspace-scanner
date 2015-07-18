package scanner

import dispatch.{Http, as, url}
import org.joda.time.LocalDate

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

import upickle._
import upickle.default._

object Hotness {

  def calc(group: MeetupGroup): Double = {
    val now = new LocalDate()
    val timeRange = s"${now.minusMonths(6).toDate.getTime}%2C${now.plusMonths(3).toDate.getTime}"
    val svc = url(s"https://api.meetup.com/2/events?offset=0&format=json&limited_events=False&group_id=${group.id}&photo-host=public&time=$timeRange&page=20&fields=&order=time&desc=false&status=upcoming&key=1e7567444f71b28447db5b1211d60&sign=true")

    val json: String = Await.result(Http(svc OK as.String), 10.seconds)

    val response = read[Response](json)

    response.results.size
    
    //response.results.foldRight(0.0)((h, t) => eventHotness(h) + t) * response.results.size
  }
  
//  def eventHotness(event: Event): Double = {
//    val limit = event.rsvp_limit.getOrElse(1)
//    val count = event.yes_rsvp_count.getOrElse(0)
//
//    count / limit
//  }
  
}
