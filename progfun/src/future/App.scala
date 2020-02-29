package future

import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureSample extends App{
  implicit val baseTime = System.currentTimeMillis
  println(baseTime)
  val f = Future{
    sleep(1020)
    11232*1232
  }
  
  val result = Await.result(f, 1.seconds)
  println(result)
  sleep(1000)
  
  def sleep(time: Long) { Thread.sleep(time) }

}