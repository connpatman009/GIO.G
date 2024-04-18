
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * three arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page and an `AssetFinder`
 * to define to reverse route static assets.
 */
  def apply/*8.2*/(title: String)(content: Html)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.69*/("""

"""),format.raw/*10.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*13.62*/("""
        """),format.raw/*14.9*/("""<title>"""),_display_(/*14.17*/title),format.raw/*14.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*15.54*/assetsFinder/*15.66*/.path("stylesheets/main.css")),format.raw/*15.95*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.59*/assetsFinder/*16.71*/.path("images/favicon.png")),format.raw/*16.98*/("""">
        <script src=""""),_display_(/*17.23*/assetsFinder/*17.35*/.path("javascripts/hello.js")),format.raw/*17.64*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),format.raw/*21.32*/("""
        """),_display_(/*22.10*/content),format.raw/*22.17*/("""
    """),format.raw/*23.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(assetsFinder)

  def f:((String) => (Html) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (assetsFinder) => apply(title)(content)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: e4fde703f65b35153a435287d8587db97a8a410b
                  MATRIX: 1073->334|1235->401|1266->405|1349->513|1386->523|1421->531|1447->536|1537->599|1558->611|1608->640|1697->702|1718->714|1766->741|1819->767|1840->779|1890->808|1987->968|2025->979|2053->986|2086->992
                  LINES: 27->8|32->8|34->10|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|44->21|45->22|45->22|46->23
                  -- GENERATED --
              */
          