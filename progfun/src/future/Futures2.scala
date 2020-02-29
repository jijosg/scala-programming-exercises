package future

import scala.util.Random
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
import scala.util.Failure

object Futures2 {
  def sleep(time: Long) { Thread.sleep(time) }
  println("Starting calculation")
  val f = Future {
    sleep(Random.nextInt(500))
    42
  }
  println("Before oncomplete")
  f.onComplete {
    case Success(value) => println(s"Got the callback, meaning  = $value")
    case Failure(e)     => e.printStackTrace()
  }
  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)
  println("E ..."); sleep(100)
  println("F ..."); sleep(100)
  sleep(2000)
}

object Futures3 extends App {
  def sleep(time: Long) { Thread.sleep(time) }

  val f = Future {
    sleep(Random.nextInt(500))
    if (Random.nextInt(500) > 250) throw new Exception("Yikes!") else 42
  }
  f onSuccess {
    case result => println(s"Success: $result")
  }
  f onFailure {
    case t => println(s"Exception: ${t.getMessage}")
  }

  // do the rest of your work
  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)
  println("E ..."); sleep(100)
  println("F ..."); sleep(100)
  sleep(2000)
}