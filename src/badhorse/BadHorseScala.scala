package badhorse

object BadHorseScala extends App {

  type Henchman = String
  type TroublesomePair = (Henchman, Henchman)

  import scala.io._
  val lines = Source.fromFile("src/badhorse/A-small-practice-1.in").getLines
  lines.next // drop #cases
  var c = 1

  for (line <- lines) {
    val count = line.toInt
    val conflicts: Seq[TroublesomePair] =
      (0 until count).map(_ => lines.next).map(line => (line.split(" ")(0), line.split(" ")(1)))
    val henchmen: Set[Henchman] = conflicts.flatMap(pair => Set[Henchman](pair._1, pair._2)).toSet

    def enemies(henchman: Henchman): Set[Henchman] =
      conflicts.filter(pair => pair._1 == henchman || pair._2 == henchman).flatMap(pair => Set[Henchman](pair._1, pair._2)).toSet - henchman

    val dislikes: Map[Henchman, Set[Henchman]] = henchmen.map(henchman => (henchman, enemies(henchman))).toMap

    def likeEachOther(people: Set[Henchman]) = people.forall(p => (dislikes(p).intersect(people)).isEmpty)

    val solvable = dislikes.values.forall(enemies => likeEachOther(enemies))

    val res = if (solvable) "Yes" else "No"
    println(s"Case #$c: $res")
    c = c+1
  }
}
