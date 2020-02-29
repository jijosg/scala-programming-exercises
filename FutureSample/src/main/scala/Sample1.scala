package main.scala

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Sample1 extends App {
  @volatile var totalA = 0
  val text = Future {
    "na" * 16 + "BATMAN!!!"
  }
  text onSuccess {
    case txt => totalA += txt.count(_ == 'a');println(totalA);
  }
  text onSuccess {
    case txt => totalA += txt.count(_ == 'A');println(totalA);
  }
  Thread.sleep(1000)
}