package models

import actors.NotificationActor
import models.dao.FavouriteStudioDAO
import play.api.libs.concurrent.Akka
import play.api.libs.functional.syntax._
import play.api.libs.json._

import play.api.Play.current

object FavouriteStudio {
  val notificationActor = Akka.system.actorOf(NotificationActor.props)

  implicit val favouriteStudioWrites: Writes[FavouriteStudio] = (
    (JsPath \ "userId").write[Int] and
      (JsPath \ "studioId").write[Int]
    )(unlift(FavouriteStudio.unapply))

  def addFavourite(userId: Int, studioId: Int): FavouriteStudio = {
    val favourite = FavouriteStudio(userId, studioId)

    FavouriteStudioDAO.create(favourite)

    notificationActor ! favourite

    favourite
  }

  def delete(userId: Int, studioId: Int) =
    FavouriteStudioDAO.delete(FavouriteStudio(userId, studioId))

  def findAllByUser(userId: Int): List[FavouriteStudio] =
    FavouriteStudioDAO.index(userId)

  def find(userId: Int, studioId: Int): Option[FavouriteStudio] = {
    val favourite = FavouriteStudio(userId, studioId)

    if (FavouriteStudioDAO.exists(favourite))
      Some(favourite)
    else
      None
  }
}

case class FavouriteStudio(userId: Int, studioId: Int)