package scanner

case class MeetupGroup(
  id: Int,
  name: String,
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
  private val keywords = Seq(
    "scala",
    "scalaz",
    "scalajs",
    "monad",
    "functor",
    "functional",
    "lambda",
    "closure"
  )

  private def frequency(word: String, text: String): Int =
    text.split(" ").toList.count { w =>
      w.toLowerCase.contains(word)
    }

  implicit val ranking = Ranking[MeetupGroup] { group =>
    keywords.map { kw =>
      frequency(kw, group.name) * 10 +
      frequency(kw, group.description)
    }.sum
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

// case class GroupStats(
//   group: MeetupGroup,
//   termCount: Int
// ) {
//   override def toString = s"${group.name} : $termCount"
// }