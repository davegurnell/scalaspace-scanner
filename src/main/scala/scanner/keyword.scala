package scanner

object Keyword extends Keyword

trait Keyword {
  val core = Seq(
    "scala",
    "akka"
  )

  val all = core ++ Seq(
    "scalaz",
    "scalajs",
    "play",
    "spray",
    "slick",
    "spark",
    "monad",
    "functor",
    "functional",
    "lambda",
    "closure"
  )

  def weight(keyword: String, text: String): Double = {
    val lcKeyword = keyword.toLowerCase
    val textWords = text.split(" ").toList
    textWords.count(_.toLowerCase.contains(lcKeyword)) /
      textWords.length
  }

  def weight(keywords: Seq[String], text: String): Double =
    keywords.map(weight(_, text)).sum

  def exists(keywords: Seq[String], text: String): Boolean =
    weight(keywords, text) > 0.0
}