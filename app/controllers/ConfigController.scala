package controllers

import java.io.{FileInputStream, InputStream}

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
import edu.pitt.cs.db.core.Controller._
import edu.pitt.cs.db.models._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ConfigController @Inject()(cc: ControllerComponents) (implicit exec: ExecutionContext)  extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def genGraph: Action[AnyContent] = Action.async {
    (request: Request[AnyContent]) =>
        getNewGraph(request).map {msg => Ok(msg)}
  }

  private def getNewGraph(request: Request[AnyContent]): Future[JsValue] = {
    val promise: Promise[JsValue] = Promise[JsValue]()
    val body: JsValue = request.body.asJson.get
    // Convert to GraphConfig
    val config = Json.fromJson[GraphConfig](body).get
    // Call random_graph(config) from controller in path finding core
    val graph = random_graph(config)
    // Return the ArrayBuffer[Building] to the front end as a JSON object
    promise.success(Json.toJson(graph))
    promise.future
  }

}
