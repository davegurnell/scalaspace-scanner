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

case class GroupStats(
  group: MeetupGroup,
  termCount: Int
) {
  override def toString = s"${group.name} : $termCount"
}