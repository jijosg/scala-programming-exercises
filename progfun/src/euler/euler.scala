package euler

import scala.math._

object euler extends App {

  /**
   * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
   * The sum of these multiples is 23.
   * Find the sum of all the multiples of 3 or 5 below 1000.
   */

  val l = for(i <- 1.until(1000) filter(x => (x % 5 == 0 || x % 3 == 0)) ) yield i
  println(l.foldLeft(0)(_+_))
  
  def checkPrime(n:Int):Boolean = n match{
    case x if x<=1 => false
    case 2 => true
    case n => if((2 to sqrt(n).toInt).takeWhile(x =>n%x==0).size == 0) true else false 
  }
  println(checkPrime(11))
  println(gcd(36,63))
  
  //Determine the greatest common divisor of two positive integer numbers.
  def gcd(a:Int,b:Int):Int = if(b==0) a else gcd(b,a%b)
  
  //Determine whether two positive integer numbers are coprime.
  
  class S99Int(val start:Int){
    def isCoprimeTo(n:Int):Boolean = gcd(start,n)==1   
  }
  
  println( new S99Int(34).isCoprimeTo(64))
  
  def and(m:Boolean,n:Boolean):Boolean = (m,n) match{
    case (true,true) => true
    case _ => false
  }
  
  println(and(true, true))
  

}