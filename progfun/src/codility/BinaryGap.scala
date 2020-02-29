package codility

import scala.math.ceil
import scala.util.control.Breaks._

object BinaryGap extends App {
  def solution(n: Int): Int = {
    val binaryString = n.toBinaryString
    val length = binaryString.length()
    val splitArray = binaryString.split("1").toBuffer
    if (binaryString.charAt(0) == '0') {
      splitArray.remove(0)
    }
    if (binaryString.charAt(length - 1) == '0') {
      splitArray.remove(splitArray.size - 1)
    }
    if (splitArray.isEmpty) {
      0
    } else {
      splitArray.map { x => x.length }.max
    }
  }
  println(solution(1048))

  def cyclicRotation(a: Array[Int], k: Int): Array[Int] = {
    val list = a.toList
    val arrayLength = list.length
    val rotCount = if (k > arrayLength) { k % arrayLength } else k
    var finalList = List[Int]()
    var i = 0
    for (i <- 1 to rotCount) {
      finalList = list.slice(arrayLength - 1, arrayLength)
      finalList ++= list.slice(0, arrayLength - 1)
    }
    finalList.toArray
  }

  def getOdd(arr: Array[Int]) = {
    if (arr.isEmpty) {
      throw new Exception("Empty array")
    } else {
      arr.reduce((x, y) => x ^ y)
    }
  }

  def frogJmp(x: Int, y: Int, d: Int): Int = {
    if (y < x || y == 0 || d == 0) {
      0
    } else {
      ceil((y - x).toDouble / d).toInt
    }
  }

  def permMissingElem(a: Array[Int]): Int = {
    val sum = a.sum
    val sum2 = (1.to(a.length + 1)).sum
    sum2 - sum
  }

  def TapeEqbm(a: Array[Int]): Int = {
    var head = a.head
    var tail = a.tail.sum
    var min = math.abs(head - tail)
    for (i <- 1 to a.length - 1) {
      head += a(i)
      tail -= a(i)
      if (math.abs(head - tail) < min) {
        min = math.abs(head - tail)
      }
    }
    min
  }

  def  frogJump(x:Int, a: Array[Int]): Int = {
    if(a.contains(x)){
      a.indexOf(x)
    }else{
      -1
    }
  }

  println(getOdd(Array(9, 3, 9, 3, 9, 7, 9)))
  println(cyclicRotation(Array(1, 2, 4, 5, 7, 8), 3).toList)
  println(frogJmp(10, 85, 30))
  println(frogJmp(40, 30, 10))
  println(permMissingElem(Array(1, 2, 5, 6, 7, 4)))
  println(TapeEqbm(Array(3, 2, 1, 4, 3)))
  println(TapeEqbm(Array(0, 2000)))
  println(frogJump(4,Array(1, 3, 6, 4, 1, 2)))
  println(frogJump(-4,Array(-1,-3, -6,0, -4, 1, -2)))
}