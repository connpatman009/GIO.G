package edu.pitt.cs.db.models

import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax.toFunctionalBuilderOps

object Congestion {
  implicit val congestionReads: Reads[Congestion] = (
    (JsPath \ "id").read[Int] and
      (JsPath \ "timestep").read[Double] and
      (JsPath \ "lower").read[Int] and
      (JsPath \ "upper").read[Int] and
      (JsPath \ "min").read[Double] and
      (JsPath \ "max").read[Double] and
      (JsPath \ "avg").read[Double] and
      (JsPath \ "stdDev").read[Double]
    )(Congestion.apply _)

  implicit val congestionWrites: Writes[Congestion] = (
    (JsPath \ "id").write[Int] and
      (JsPath \ "timestep").write[Double] and
      (JsPath \ "lower").write[Int] and
      (JsPath \ "upper").write[Int] and
      (JsPath \ "min").write[Double] and
      (JsPath \ "max").write[Double] and
      (JsPath \ "avg").write[Double] and
      (JsPath \ "stdDev").write[Double]
    )(c => (c.id, c.timestep, c.lower, c.upper, c.min, c.max, c.avg, c.stdDev))
}

case class Congestion(id: Int,
                      timestep: Double,
                      lower: Int,
                      upper: Int,
                      min: Double,
                      max: Double,
                      avg: Double,
                      stdDev: Double) {
  override def toString: String = s"$id,$timestep,$lower,$upper,$min,$max,$avg,$stdDev"
}
