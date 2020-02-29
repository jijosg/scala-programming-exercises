package controllers

import java.sql.Timestamp
import javax.inject.Inject

import models._
import org.joda.time.DateTime
import play.api.i18n.MessagesApi
import play.api.libs.json.Json._
import play.api.libs.json._
import play.api.mvc.{Action, Controller}
import service._
import views._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

/**
  * Created by Jijo Sunny on 26-04-2017.
  */
class SlickController @Inject()(implicit val messagesApi: MessagesApi) extends Controller {

  def list(env: String) = Action.async { implicit request =>
    val processList = WorkflowService.list(env)
    for (process <- processList) yield Ok(html.listworkflow(env, process))
  }

  /*def get(id: Int) = Action.async { implicit request =>
    WorkflowService.get(id).map { case Some(p) => Ok(html.list(p))
    case None => NotFound("Not found")
    }
  }*/
  def getStage(env: String, id: Int) = Action.async { implicit request =>
    val stageList = WorkflowService.getStage(env, id)
    for (stage <- stageList) yield Ok(html.liststage(env, stage))
  }

  /*def getTask(env: String, id: Int) = Action.async { implicit request =>
    val taskList = WorkflowService.getTask(env, id)
    Await.result(taskList, Duration.Inf).andThen {
      case Success(x) => {
        val task22 = for (task <- x) yield task
        println(task22)
        Ok("Got data")
      }
      case Failure(err) => {
        println(err)
        NotFound("Process not found")
      }
    }
  }*/
}