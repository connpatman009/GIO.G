package edu.pitt.cs.db.models

import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax.toFunctionalBuilderOps
import scala.collection.mutable.ArrayBuffer

object Building {
  implicit val buildingReads: Reads[Building] = ((JsPath \ "id").read[Int] and
    (JsPath \ "x").read[Int] and
    (JsPath \ "y").read[Int] and
    (JsPath \ "entrances").read[ArrayBuffer[Entrance]] and
    (JsPath \ "congestion_type").read[String] and
    (JsPath \ "congestion").read[ArrayBuffer[Congestion]] and
    (JsPath \ "merged_x").read[ArrayBuffer[Int]] and
    (JsPath \ "merged_y").read[ArrayBuffer[Int]])(Building.apply _)

  implicit val buildingWrites: Writes[Building] = ((JsPath \ "id").write[Int] and
    (JsPath \ "x").write[Int] and
    (JsPath \ "y").write[Int] and
    (JsPath \ "entrances").write[ArrayBuffer[Entrance]] and
    (JsPath \ "congestion_type").write[String] and
    (JsPath \ "congestion").write[ArrayBuffer[Congestion]] and
    (JsPath \ "merged_x").write[ArrayBuffer[Int]] and
    (JsPath \ "merged_y").write[ArrayBuffer[Int]])(b => (b.id, b.x, b.y, b.entrances, b.congestion_type, b.congestion, b.merged_x, b.merged_y))
}

case class Building(id: Int, x: Int, y: Int, entrances: ArrayBuffer[Entrance], congestion_type: String, congestion: ArrayBuffer[Congestion], merged_x: ArrayBuffer[Int], merged_y: ArrayBuffer[Int]) {
  val addEntrance: (Int, Double, Double, Int) => ArrayBuffer[Entrance] =
    (id: Int, x: Double, y: Double, accessibility: Int) => entrances += Entrance(id, x, y, accessibility)
  val addCongestion: (Int, Double, Int, Int, Double, Double, Double, Double) => ArrayBuffer[Congestion] =
    (id: Int, timestep: Double, lower: Int, upper: Int, min: Double, max: Double, avg: Double, stdDev: Double) =>
      congestion += Congestion(id, timestep, lower, upper, min, max, avg, stdDev)
  val merge: (Building) => Unit =
    (newBuilding: Building) => {
      // Rename the entrances of the new building to continue from the old entrance numbering
      var currE = entrances.length + 1
      for (newE <- newBuilding.entrances) {
        newE.id = currE
        currE += 1
      }
      entrances ++= newBuilding.entrances
      merged_x ++= newBuilding.merged_x
      merged_y ++= newBuilding.merged_y
      merged_x += newBuilding.x
      merged_y += newBuilding.y
      // Congestion inherited from the base building
    }

  override def toString: String = entrances.map(e => s"GenBuilding$id,$x,$y,$e\n").mkString
}
