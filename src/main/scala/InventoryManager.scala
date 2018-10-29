import java.io.{File, PrintWriter}

import javax.swing.JProgressBar
import play.api.libs.json.Json
import scalaj.http._

case class MTGCard(name: String, edition: String, image: String)

object InventoryManager {
  // TODO: loadHelper needs to take a database to write to
  def loadHelper(baseurl: String, page: Int, callback: Int => Unit): Unit = {
    val response = if (page == 0)
      Http(baseurl).asString
     else
      Http(baseurl).param("page", page.toString).asString
    val json = Json.parse(response.body)
    val lst = json("items")
    // TODO: Put all the cards from lst into a database
    // Also at some point we'll want this method to update a progress bar
    val pageNum = json("page").asOpt[Int]
    val totalPages = json("total_pages").asOpt[Int]
    pageNum match {
      case Some(p) => totalPages match {
        case Some (tp) => if (p < tp) {
          callback(100 * p / tp)
          loadHelper(baseurl, p + 1, callback)
        } else Unit
        case None => throw new Exception("Deckbox response without total pages")
      }
      case None => throw new Exception("Deckbox response without page number")
    }
  }

  def loadCollection(username: String, callback: Int => Unit): Unit = {
    val dir = new File("cache")
    if (!dir.exists()) {
      dir.mkdir()
    }
    // TODO: Pass a database to loadHelper
    loadHelper(
      "https://deckbox-api.herokuapp.com/api/users/" + username + "/inventory",
      0, callback)
  }

  def queryName(username: String, cardName: String): Seq[String] = {
    // TODO
    List("")
  }
}
