package edu.pitt.cs.db
import play.api.libs.json.{JsObject, Json, Writes}


package object models {

  implicit val elementsWrites: Writes[Elements] {
    def writes(elements: Elements): JsObject
  } = new Writes[Elements] {
    def writes(elements: Elements) = Json.obj(
      "nodes" -> elements.getNodes
      ,
      "edges" -> elements.getEdges
    )
  }

  implicit val dataNodeWrites: Writes[DataNode] {
    def writes(dataNode: DataNode): JsObject
  } = new Writes[DataNode] {
    def writes(dataNode: DataNode) = Json.obj(
      "data" -> Json.obj(
        "name" -> dataNode.name,
        "id" -> dataNode.id
      ))
  }


  implicit val dataEdgeWrites: Writes[DataEdge] {
    def writes(dataEdge: DataEdge): JsObject
  } = new Writes[DataEdge] {
    def writes(dataEdge: DataEdge) = Json.obj(
      "data" -> Json.obj(
        "id" -> dataEdge.id,
        "label" -> dataEdge.label,
        "source" -> dataEdge.source,
        "target" -> dataEdge.target,
        "weight" -> BigDecimal(dataEdge.weight).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
        ,
      ))
  }

}
