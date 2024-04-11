package edu.pitt.cs.db.models

import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax.toFunctionalBuilderOps

object PathConfig {
  implicit val pathConfigReads: Reads[PathConfig] = ((JsPath \ "algorithm").read[String] and
    (JsPath \ "accessible").read[Boolean] and
    (JsPath \ "start_id").read[Int] and
    (JsPath \ "start_x").read[Int] and
    (JsPath \ "end_x").read[Int] and
    (JsPath \ "end_y").read[Int])(PathConfig.apply _)

  implicit val pathConfigWrites: Writes[PathConfig] = ((JsPath \ "algorithm").write[String] and
    (JsPath \ "accessible").write[Boolean] and
    (JsPath \ "start_x").write[Int] and
    (JsPath \ "start_y").write[Int] and
    (JsPath \ "end_x").write[Int] and
    (JsPath \ "end_y").write[Int])(pc => (pc.algorithm, pc.accessible, pc.start_x, pc.start_y, pc.end_x, pc.end_y))
}

case class PathConfig(algorithm: String, accessible: Boolean, start_x: Int, start_y: Int, end_x: Int, end_y: Int) {
  override def toString: String = s"PathConfig$algorithm,$accessible,$start_x,$start_y,$end_x,$end_y"
}
