package controllers

import java.io.{FileInputStream, InputStream}

import akka.actor.ActorSystem
import javax.inject._
import play.Environment
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
class ConfigController @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def path = Action.async {
    getPath().map { msg => Ok(msg) }
  }

  def getPath(): Future[JsValue] = {
    val promise: Promise[JsValue] = Promise[JsValue]()
    actorSystem.scheduler.scheduleOnce(1.second) {
      val x: JsValue = Json.obj("path" -> "found")
      promise.success(x)
    }(actorSystem.dispatcher) // run scheduled tasks using the actor system's dispatcher
    promise.future
  }

}
