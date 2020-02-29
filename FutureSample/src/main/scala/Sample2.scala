package main.scala

import scala.concurrent.{ Future, Promise }
import scala.concurrent.ExecutionContext.Implicits.global

object Sample2 extends App{
  val f = Future{1}
  val p = Promise[Int]()
  p completeWith f
  p.future onSuccess{
    case x => println(x)
  }
  Thread.sleep(10)
}