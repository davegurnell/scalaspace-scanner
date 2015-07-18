package scanner

import upickle.Js
import upickle.default.Writer

import java.util.Date

import scala.concurrent.duration.Duration

case class MeetupGroup(
  id: Int,
  name: String,
  urlname: String,
  link: String,
  city: String,
  country: String,
  description: String,
  lat: Double,
  lon: Double,
  members: Int,
  organizer: Organizer,
  // group_photo // for later maybe
  category: Category,
  score: Double
)

object MeetupGroup {
  implicit val ranking: Ranking[MeetupGroup] =
    Ranking[MeetupGroup] { group =>
      Keyword.weight(Keyword.all, group.name) * 10 +
      Keyword.weight(Keyword.all, group.description)
    }

  implicit val writer: Writer[MeetupGroup] =
    Writer[MeetupGroup] { group =>
      Js.Arr(
        Js.Str(group.name),
        Js.Str(group.urlname),
        Js.Num(group.lat),
        Js.Num(group.lon),
        if(Keyword.exists(Keyword.core, group.name)) Js.True else Js.False
      )
    }
}

case class Organizer(
  id: Int,
  name: String,
  bio: String
)

case class Category(
  id: Int,
  name: String,
  shortname: String
)

case class Response(results: Seq[Event])

case class Event(
  id: String,
  name: String
//  yes_rsvp_count: Option[Int],
//  rsvp_limit: Option[Int],
//  time: Duration,
//  waitlist_count: Option[Int]
)

// case class GroupStats(
//   group: MeetupGroup,
//   termCount: Int
// ) {
//   override def toString = s"${group.name} : $termCount"
// }