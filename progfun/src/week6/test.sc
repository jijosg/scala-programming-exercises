package week6

object test {
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)

  val s = "Hello World!"                          //> s  : String = Hello World!
  s filter (x => x.isUpper)                       //> res1: String = HW
  
  xs zip s                                        //> res2: Array[(Int, Char)] = Array((1,H), (2,e), (3,l), (44,l))
  
  //(1 to M) flatMap (x => (1 to N) map (y =>(x,y)))
  
  def scalarProduct(xs:Vector[Int],ys:Vector[Int]):Int= {
  	(xs zip ys).map( x => x._1 * x._2 ).sum
  }                                               //> scalarProduct: (xs: Vector[Int], ys: Vector[Int])Int
  
  
  
  scalarProduct(Vector(1,2,3), Vector(4,5,6))     //> res3: Int = 32
  
  def isPrime(n:Int):Boolean = (2 until n) forall (d => n%d !=0)
                                                  //> isPrime: (n: Int)Boolean
  
  isPrime(17)                                     //> res4: Boolean = true
  
   val n = 7                                      //> n  : Int = 7
  	(1 until n) flatMap ( i => (1 until i) map (j => (i,j))) filter(pair => isPrime(pair._1+pair._2))
                                                  //> res5: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  
}