package edu.pitt.cs.db.models

import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax.toFunctionalBuilderOps

object Entrance {
  implicit val entranceReads: Reads[Entrance] = ((JsPath \ "id").read[Int] and
    (JsPath \ "x").read[Double] and
    (JsPath \ "y").read[Double] and
    (JsPath \ "accessible").read[Int])(Entrance.apply _)

  implicit val entranceWrites: Writes[Entrance] = ((JsPath \ "id").write[Int] and
    (JsPath \ "x").write[Double] and
    (JsPath \ "y").write[Double] and
    (JsPath \ "accessible").write[Int])(e => (e.id, e.x, e.y, e.accessible))
}

case class Entrance(var id: Int, x: Double, y: Double, accessible: Int) {
  override def toString: String = s" Entrance$id,$x,$y,$accessible"
}
