package week1

object session {
  1 + 5                                           //> res0: Int(6) = 6
  def abs(x: Double): Double = if (x < 0) -x else x
                                                  //> abs: (x: Double)Double
  abs(-2.4)                                       //> res1: Double = 2.4

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double
  sqrt(3)                                         //> res2: Double = 1.7321428571428572
  sqrt(1e-6)                                      //> res3: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res4: Double = 1.0000788456669446E30
  
  
  def factorial(x:Int):Int = if(x==0) 1 else x * factorial(x-1)
                                                  //> factorial: (x: Int)Int
  
  factorial(5)                                    //> res5: Int = 120
}