package main.testFuture

import org.scalatest._
import scala.concurrent.Future
import main.scala.Cloud
import scala.util.Random
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
import scala.util.Failure
import org.scalatest.concurrent.ScalaFutures

class Futures5Test extends FunSuite with Matchers with ScalaFutures {
  test("Test a asynchronous method synchronously") {
    val futureResult = Cloud.runAlgorithm(1)

    futureResult onComplete {
      case Success(value) => value equals Some(1)
      case Failure(exp)   => fail(exp)
    }
  }
}