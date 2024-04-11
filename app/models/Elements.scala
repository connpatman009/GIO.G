package edu.pitt.cs.db.models

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class Elements() {

  def getNodes: mutable.ListBuffer[DataNode] = nodes

  def getEdges: ListBuffer[DataEdge] = edges

  var nodes = new mutable.ListBuffer[DataNode]
  var edges = new mutable.ListBuffer[DataEdge]

}
