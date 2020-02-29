package future

import scala.concurrent.{ Await, Future }
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
import scala.util.Failure

object Futures4 extends App {
  def sleep(time: Long) { Thread.sleep(time) }
  def longRunningComputation(i: Int): Future[Int] = Future {
    sleep(100)
    i + 1
  }

  // this does not block
  longRunningComputation(21).onComplete {
    case Success(result) => println(s"result = $result")
    case Failure(e)      => e.printStackTrace
  }

  // important: keep the jvm from shutting down
  sleep(1000)
}