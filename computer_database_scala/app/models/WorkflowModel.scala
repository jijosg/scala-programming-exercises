package models

import java.sql.Timestamp

import slick.driver.PostgresDriver.api._

/**
  * Created by Jijo Sunny on 26-04-2017.
  */
case class Process(id: Option[Int], process_name: String, description: String, active_flag: String, created_at: Timestamp, updated_at: Timestamp, create_user: String, update_user: String, process_type: String, can_restart_if_completed: String)

object Process {

  class ProcessT(tag: Tag) extends Table[Process](tag, "ze_wla_process") {

    // Every table needs a * projection with the same type as the table's type parameter
    def * = (id.?, process_name, description, active_flag, created_at, updated_at, create_user, update_user, process_type, can_restart_if_completed) <> ((Process.apply _).tupled, Process.unapply)

    def id: Rep[Int] = column[Int]("id", O.PrimaryKey) // This is the primary key column

    def process_name: Rep[String] = column[String]("process_name")

    def description: Rep[String] = column[String]("description")

    def active_flag: Rep[String] = column[String]("active_flag")

    def created_at: Rep[Timestamp] = column[Timestamp]("created_at")

    def updated_at: Rep[Timestamp] = column[Timestamp]("updated_at")

    def create_user: Rep[String] = column[String]("create_user")

    def update_user: Rep[String] = column[String]("update_user")

    def process_type: Rep[String] = column[String]("process_type")

    def can_restart_if_completed: Rep[String] = column[String]("can_restart_if_completed")
  }

  val process = TableQuery[ProcessT]
}

case class Stage(id: Int, process_id: Int, stage_name: String, stage_order: Int, description: String, active_flag: String, created_at: Timestamp, updated_at: Timestamp, create_user: String, update_user: String)

object Stage {

  class StageT(tag: Tag) extends Table[Stage](tag, "ze_wla_stage") {
    def * = (id, process_id, stage_name, stage_order, description, active_flag, created_at, updated_at, create_user, update_user) <> ((Stage.apply _).tupled, Stage.unapply)

    def id: Rep[Int] = column[Int]("id", O.PrimaryKey) // This is the primary key column

    def process_id: Rep[Int] = column[Int]("process_id")

    def stage_name: Rep[String] = column[String]("stage_name")

    def stage_order: Rep[Int] = column[Int]("stage_order")

    def description: Rep[String] = column[String]("description")

    def active_flag: Rep[String] = column[String]("active_flag")

    def created_at: Rep[Timestamp] = column[Timestamp]("created_at")

    def updated_at: Rep[Timestamp] = column[Timestamp]("updated_at")

    def create_user: Rep[String] = column[String]("create_user")

    def update_user: Rep[String] = column[String]("update_user")
  }

  val stage = TableQuery[StageT]
}


case class TaskGroup(id: Int, stage_id: Int, task_group_name: String, task_group_order: Int, description: String, active_flag: String, created_at: Timestamp, updated_at: Timestamp, create_user: String, update_user: String)

object TaskGroup {

  class TaskGroupT(tag: Tag) extends Table[TaskGroup](tag, "ze_wla_task_group") {
    def * = (id, stage_id, task_group_name, task_group_order, description, active_flag, created_at, updated_at, create_user, update_user) <> ((TaskGroup.apply _).tupled, TaskGroup.unapply)

    def id: Rep[Int] = column[Int]("id", O.PrimaryKey) // This is the primary key column

    def stage_id: Rep[Int] = column[Int]("stage_id")

    def task_group_name: Rep[String] = column[String]("task_group_name")

    def task_group_order: Rep[Int] = column[Int]("task_group_order")

    def description: Rep[String] = column[String]("description")

    def active_flag: Rep[String] = column[String]("active_flag")

    def created_at: Rep[Timestamp] = column[Timestamp]("created_at")

    def updated_at: Rep[Timestamp] = column[Timestamp]("updated_at")

    def create_user: Rep[String] = column[String]("create_user")

    def update_user: Rep[String] = column[String]("update_user")
  }

  val taskgroup = TableQuery[TaskGroupT]
}

case class Task(id: Int, task_group_id: Int, task_name: String, task_type: String, task_command: String, description: String, active_flag: String, created_at: Timestamp, updated_at: Timestamp, create_user: String, update_user: String, client_id: Option[Int], task_order: Int)

object Task {

  class TaskT(tag: Tag) extends Table[Task](tag, "ze_wla_task") {
    def * = (id, task_group_id, task_name, task_type, task_command, description, active_flag, created_at, updated_at, create_user, update_user, client_id.?, task_order) <> ((Task.apply _).tupled, Task.unapply)

    def id: Rep[Int] = column[Int]("id", O.PrimaryKey) // This is the primary key column

    def task_group_id: Rep[Int] = column[Int]("task_group_id")

    def task_name: Rep[String] = column[String]("task_name")

    def task_type: Rep[String] = column[String]("task_type")

    def task_command: Rep[String] = column[String]("task_command")

    def description: Rep[String] = column[String]("description")

    def active_flag: Rep[String] = column[String]("active_flag")

    def created_at: Rep[Timestamp] = column[Timestamp]("created_at")

    def updated_at: Rep[Timestamp] = column[Timestamp]("updated_at")

    def create_user: Rep[String] = column[String]("create_user")

    def update_user: Rep[String] = column[String]("update_user")

    def client_id: Rep[Int] = column[Int]("client_id")

    def task_order: Rep[Int] = column[Int]("task_order")

  }

  val task = TableQuery[TaskT]
}


case class Dependency(id: Int, task_id: Int, pred_task_id: Int, action_on_failure: Option[String], active_flag: String, created_at: Timestamp, updated_at: Timestamp, create_user: String, update_user: String)

object Dependency {

  class DependencyT(tag: Tag) extends Table[Dependency](tag, "ze_wla_dependency") {
    def * = (id, task_id, pred_task_id, action_on_failure.?, active_flag, created_at, updated_at, create_user, update_user) <> ((Dependency.apply _).tupled, Dependency.unapply)

    def id: Rep[Int] = column[Int]("id", O.PrimaryKey) // This is the primary key column

    def task_id: Rep[Int] = column[Int]("task_id")

    def pred_task_id: Rep[Int] = column[Int]("pred_task_id")

    def action_on_failure: Rep[String] = column[String]("action_on_failure")

    def active_flag: Rep[String] = column[String]("active_flag")

    def created_at: Rep[Timestamp] = column[Timestamp]("created_at")

    def updated_at: Rep[Timestamp] = column[Timestamp]("updated_at")

    def create_user: Rep[String] = column[String]("create_user")

    def update_user: Rep[String] = column[String]("update_user")
  }

  val dependency = TableQuery[DependencyT]
}