package edu.pitt.cs.db.models

import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax.toFunctionalBuilderOps

object GraphConfig {
  implicit val graphConfigReads: Reads[GraphConfig] = ((JsPath \ "num_buildings").read[Int] and
    (JsPath \ "coverage").read[Double] and
    (JsPath \ "clustering").read[Double] and
    (JsPath \ "constant_congestion").read[Boolean] and
    (JsPath \ "high_con").read[Double] and
    (JsPath \ "med_con").read[Double] and
    (JsPath \ "low_con").read[Double])(GraphConfig.apply _)

  implicit val graphConfigWrites: Writes[GraphConfig] = ((JsPath \ "num_buildings").write[Int] and
    (JsPath \ "coverage").write[Double] and
    (JsPath \ "clustering").write[Double] and
    (JsPath \ "constant_congestion").write[Boolean] and
    (JsPath \ "high_con").write[Double] and
    (JsPath \ "med_con").write[Double] and
    (JsPath \ "low_con").write[Double])(gc => (gc.num_buildings, gc.coverage, gc.clustering, gc.constant_congestion, gc.high_con, gc.med_con, gc.low_con))
}

case class GraphConfig(num_buildings: Int, coverage: Double, clustering: Double, constant_congestion: Boolean, high_con: Double, med_con: Double, low_con: Double) {
  override def toString: String = s"GraphConfig$num_buildings,$coverage,$clustering,$constant_congestion,$high_con,$med_con,$low_con"
}
