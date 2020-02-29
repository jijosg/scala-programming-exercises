package main.scala

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Success }
import scala.util.Random

object RunningMultipleCalcs extends App {
  def sleep(n: Long) = { Thread.sleep(n) }

  def goDoSomething = {
    println("starting futures")
  
  val result1 = Cloud.runAlgorithm(10)
  val result2 = Cloud.runAlgorithm(20)
  val result3 = Cloud.runAlgorithm(30)

  println("before for-comprehension")
  val result = for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield (r1 + r2 + r3)

  println("before onSuccess")
  result onComplete  {
    case Success(r) => println(s"total = $r")
    case Failure(e) => e.printStackTrace() 
  }

  println("before sleep at the end")
  
  }
  goDoSomething
  sleep(2000) // important: keep the jvm alive
}

object Cloud {
  def runAlgorithm(i: Int): Future[Int] = Future {
    RunningMultipleCalcs.sleep(Random.nextInt(500))
    val result = i + 10
    println(s"returning result from cloud: $result")
    result
  }
}