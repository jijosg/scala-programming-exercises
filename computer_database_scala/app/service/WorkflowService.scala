package service

import models._
import slick.driver.PostgresDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * Created by Jijo Sunny on 27-04-2017.
  */
object WorkflowService {
  val process = Process.process
  val stage = Stage.stage
  val taskgroup = TaskGroup.taskgroup
  val task = Task.task
  val dependency = Dependency.dependency

  def list(env: String): Future[Seq[Process]] = {
    val db: Database = Database.forConfig("db." + env)
    db.run(process.sortBy(_.id.asc.nullsFirst).result)
  }

  /*  def get(id: Int): Future[Option[Process]] = {
      db.run(process.filter(_.id === id).result.headOption)
    }*/

  def getStage(env: String, id: Int): Future[Seq[Dependency]] = {

    //val value = process.filter(x => x.id === id).flatMap(p => stage.filter(x => x.process_id === p.id).flatMap(s => taskgroup.filter(x => x.stage_id === s.id).flatMap(tg => task.filter(x => x.task_group_id === tg.id && x.active_flag === "Y").flatMap(t => dependency.filter(x => x.task_id === t.id && x.active_flag === "Y").map(d => (d, t, p.process_name))))))

    val db: Database = Database.forConfig("db." + env)
    val value = for {p <- process if p.id === id
                     s <- stage if s.process_id === p.id
                     tg <- taskgroup if tg.stage_id === s.id
                     t <- task if t.task_group_id === tg.id && t.active_flag === "Y"
                     t1 <- task if t1.task_group_id === tg.id || t1.id === 0 && t1.active_flag === "Y"
                     d <- dependency.filter(x => x.task_id === t.id && x.active_flag === "Y" && x.pred_task_id === t1.id)
    } yield d
    db.run(value.sortBy(_.pred_task_id.asc) result)
    /*val taskList = for {p <- process.filter(x => x.id === id)
                        s <- stage.filter(x => x.process_id === p.id)
                        tg <- taskgroup.filter(x => x.stage_id === s.id)
                        t <- task.filter(x => x.task_group_id === tg.id)} yield t.id

    val future = db.run(taskList.result)
    val res = Await.result(future,Duration.Inf)
    val value = for {t <- task.filter(x => x.active_flag === "Y" && x.client_id == 0)
                     t1 <- task.filter(x => x.active_flag === "Y" && x.client_id == 0)
                     d <- dependency.filter(x => x.active_flag === "Y"  && x.pred_task_id === t1.id && x.task_id === t.id)} yield (d, t)
    val future1 = db.run(value.sortBy(_._1.pred_task_id.asc) result)
    val res1 = Await.result(future1,Duration.Inf)
    val s = for{
      r <- res1.filter(x=> res.contains(x._1.task_id))
    } yield  r
    println(s.length)
    s*/

  }

  def getTask(env: String, id: Int) = {
    val db: Database = Database.forConfig("db." + env)
    Future {
      db.run(process.filter(x => x.id === id).result)
    }
  }


  //val res1:Seq[Int] = Seq(127603, 128761, 128760, 127693, 127692, 127695, 127694, 127697, 127696, 127716, 128736, 128763, 128762, 128765, 128764, 128767, 128766, 128768, 128769, 128796, 128795, 128798, 128797, 128800, 128799, 128802, 128801, 127754, 127753, 127756, 127755, 128330, 128329, 127758, 127757, 127800, 128660, 127761, 128648, 128647, 128804, 128803, 128806, 128805, 128807, 127864, 127863, 127865, 122582, 122581, 122580, 127558, 624, 122583, 122585, 122584, 122588, 122587, 122586, 122619, 122589, 122590, 122592, 122591, 122603, 122602, 122601, 122600, 122599, 122598, 122597, 122596, 122595, 122594, 122593, 122604, 122605, 122606, 122608, 122607, 122610, 122609, 122611, 122612, 122614, 122613, 122616, 122615, 122617, 122620, 122618, 122621, 122625, 122623, 122622, 122624, 122627, 122626, 629, 627, 626, 625, 123367, 122628, 127799, 127798, 127759, 127801, 128808, 128347, 128346, 127760, 127802, 128065, 128064, 128067, 128066, 128069, 128068, 128180, 128179, 128182, 128181, 128184, 128183, 128185, 128186, 128144, 128143, 128146, 128145, 128148, 128147, 128150, 128149, 128152, 128151, 128153, 128216, 128215, 128218, 128217, 128220, 128219, 128221, 128222, 128213, 128332, 128331, 128334, 128333, 128335, 128336, 128280, 128279, 128282, 128281, 128284, 128283, 128285, 128286, 128296, 128295, 128298, 128297, 128300, 128299, 128301, 128302, 128467, 128466, 128469, 128468, 128471, 128470, 128472, 128473, 128349, 128348, 128351, 128350, 128352, 128353, 128364, 128363, 128366, 128365, 128368, 128367, 128370, 128369, 128371, 128372, 128396, 128395, 128398, 128397, 128400, 128399, 128401, 128402, 128345, 128476, 128475, 128478, 128477, 128480, 128479, 128482, 128481, 128483, 128515, 128514, 128517, 128516, 128519, 128518, 128520, 128521, 128533, 128532, 128535, 128534, 128537, 128536, 128539, 128538, 128540, 128423, 128422, 128425, 128424, 128427, 128426, 128429, 128428, 128430, 128560, 128559, 128070, 128645, 128656, 128655, 128658, 128657, 128659, 128809, 128810, 128813, 128812, 128815, 128814, 128817, 128816, 128818, 128846, 128845, 128847, 128848, 128454, 128354, 128737, 128738, 128754, 128755, 623, 126136, 126135, 126181, 126182, 126200, 126212, 126851, 126858, 126885, 126945, 126944, 126962, 126961, 126964, 126963, 126966, 126965, 127027, 127026, 127046, 127062, 127064, 127063, 127066, 127065, 127068, 127067, 127069, 127096, 127199, 127198, 127200, 127205, 127204, 127207, 127206, 127209, 127208, 127211, 127210, 127212, 127380, 127379, 127382, 127381, 127384, 127383, 127385, 127387, 127386, 127389, 127388, 127390, 127391, 127392, 127394, 127393, 127449, 127448, 127450, 127473, 127472, 127474, 127029, 127028, 127031, 127030, 127033, 127032, 127035, 127034, 127037, 127036, 127039, 127038, 127041, 127040, 127043, 127042, 127044, 127045, 127523, 127522, 127525, 127524, 127526, 127537, 127536, 127538, 127543, 127542, 127544, 127549, 127548, 127550, 127561, 127560, 127562, 127564, 127563, 127566, 127565, 127568, 127567, 127569, 127570, 127571, 127572, 127605, 127604, 127607, 127606, 127609, 127608, 127610, 127597, 127584, 127583, 127586, 127585, 127588, 127587, 127590, 127589, 127592, 127591, 127593)

}

