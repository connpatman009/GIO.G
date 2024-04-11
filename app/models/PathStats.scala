package edu.pitt.cs.db.models

import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax.toFunctionalBuilderOps

object PathStats {
  implicit val pathStatsReads: Reads[PathStats] = ((JsPath \ "time_total").read[Double] and
    (JsPath \ "time_indoor").read[Double] and
    (JsPath \ "time_outdoor").read[Double] and
    (JsPath \ "congestion_average").read[Double] and
    (JsPath \ "congestion_max").read[Double] and
    (JsPath \ "congestion_min").read[Double])(PathStats.apply _)

  implicit val pathStatsWrites: Writes[PathStats] = ((JsPath \ "time_total").write[Double] and
    (JsPath \ "time_indoor").write[Double] and
    (JsPath \ "time_outdoor").write[Double] and
    (JsPath \ "congestion_average").write[Double] and
    (JsPath \ "congestion_max").write[Double] and
    (JsPath \ "congestion_min").write[Double])(ps => (ps.time_total, ps.time_indoor, ps.time_outdoor, ps.congestion_average, ps.congestion_max, ps.congestion_min))
}

case class PathStats(time_total: Double, time_indoor: Double, time_outdoor: Double, congestion_average: Double, congestion_max: Double, congestion_min: Double) {
  override def toString: String = s"PathStats$time_total,$time_indoor,$time_outdoor,$congestion_average,$congestion_max,$congestion_min"
}
