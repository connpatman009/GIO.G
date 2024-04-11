package controllers

import java.io.{FileInputStream, InputStream}
import akka.actor.ActorSystem

import javax.inject._
import play.Environment
import play.api.libs.json.JsResult.Exception
import play.api.libs.json._
import play.api.mvc._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.language.postfixOps
import java.sql.Timestamp

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ConfigController @Inject()(cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def genGraph = Action.async { (request: Request[AnyContent]) =>
    getNewGraph(request).map { msg => Ok(msg) }
  }

  def getNewGraph(request: Request[AnyContent]): Future[JsValue] = {
    val promise: Promise[JsValue] = Promise[JsValue]()
    val config: JsValue = request.body.asJson.get     // This gets the JSON from the body of the post
    // Convert to GraphConfig (if necessary)
    // Call random_graph(config) from controller in Core
    //random_graph(config)
    // Return the ArrayBuffer[Building] to the FE
    promise.success(config)                           // Put the return JSON in the success of the promise
    promise.future
  }

}
