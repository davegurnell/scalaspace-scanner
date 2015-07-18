package scanner

trait Ranking[A] extends (A => Double)

object Ranking {
  def apply[A](func: A => Double): Ranking [A] =
    new Ranking[A] { def apply(value: A) = func(value) }
}

case class Rank[A](value: A, rank: Double)

object RankImplicits extends RankImplicits

trait RankImplicits {
  implicit class RankOps[A](value: Seq[A]) {
    def ranked(implicit ranking: Ranking[A]): Seq[Rank[A]] =
      value.
        map(item => Rank(item, ranking(item))).
        sortBy(item => -item.rank)
  }
}