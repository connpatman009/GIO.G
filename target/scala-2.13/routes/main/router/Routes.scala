// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_4: controllers.HomeController,
  // @LINE:8
  CountController_1: controllers.CountController,
  // @LINE:10
  AsyncController_3: controllers.AsyncController,
  // @LINE:13
  Assets_2: controllers.Assets,
  // @LINE:16
  ConfigController_0: controllers.ConfigController,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_4: controllers.HomeController,
    // @LINE:8
    CountController_1: controllers.CountController,
    // @LINE:10
    AsyncController_3: controllers.AsyncController,
    // @LINE:13
    Assets_2: controllers.Assets,
    // @LINE:16
    ConfigController_0: controllers.ConfigController
  ) = this(errorHandler, HomeController_4, CountController_1, AsyncController_3, Assets_2, ConfigController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_4, CountController_1, AsyncController_3, Assets_2, ConfigController_0, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """new_graph""", """controllers.ConfigController.genGraph"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """update_graph""", """controllers.ConfigController.updateGraph"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """find_path""", """controllers.ConfigController.pathFind"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:6
  private lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_4.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_1.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:10
  private lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_3.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:13
  private lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:16
  private lazy val controllers_ConfigController_genGraph4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("new_graph")))
  )
  private lazy val controllers_ConfigController_genGraph4_invoker = createInvoker(
    ConfigController_0.genGraph,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ConfigController",
      "genGraph",
      Nil,
      "POST",
      this.prefix + """new_graph""",
      """ Generate a new graph from a configuration object""",
      Seq()
    )
  )

  // @LINE:19
  private lazy val controllers_ConfigController_updateGraph5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("update_graph")))
  )
  private lazy val controllers_ConfigController_updateGraph5_invoker = createInvoker(
    ConfigController_0.updateGraph,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ConfigController",
      "updateGraph",
      Nil,
      "POST",
      this.prefix + """update_graph""",
      """ Update the graph representation on the back end from a list of buildings""",
      Seq()
    )
  )

  // @LINE:22
  private lazy val controllers_ConfigController_pathFind6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("find_path")))
  )
  private lazy val controllers_ConfigController_pathFind6_invoker = createInvoker(
    ConfigController_0.pathFind,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ConfigController",
      "pathFind",
      Nil,
      "POST",
      this.prefix + """find_path""",
      """ Update the graph representation on the back end from a list of buildings""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_4.index)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params@_) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_1.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message2_route(params@_) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_3.message)
      }
  
    // @LINE:13
    case controllers_Assets_versioned3_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned3_invoker.call(Assets_2.versioned(file))
      }
  
    // @LINE:16
    case controllers_ConfigController_genGraph4_route(params@_) =>
      call { 
        controllers_ConfigController_genGraph4_invoker.call(ConfigController_0.genGraph)
      }
  
    // @LINE:19
    case controllers_ConfigController_updateGraph5_route(params@_) =>
      call { 
        controllers_ConfigController_updateGraph5_invoker.call(ConfigController_0.updateGraph)
      }
  
    // @LINE:22
    case controllers_ConfigController_pathFind6_route(params@_) =>
      call { 
        controllers_ConfigController_pathFind6_invoker.call(ConfigController_0.pathFind)
      }
  }
}
