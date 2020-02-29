package week6

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(59); 
  val xs = Array(1, 2, 3, 44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(22); val res$0 = 
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(27); 

  val s = "Hello World!";System.out.println("""s  : String = """ + $show(s ));$skip(28); val res$1 = 
  s filter (x => x.isUpper);System.out.println("""res1: String = """ + $show(res$1));$skip(14); val res$2 = 
  
  xs zip s;System.out.println("""res2: Array[(Int, Char)] = """ + $show(res$2));$skip(164); 
  
  //(1 to M) flatMap (x => (1 to N) map (y =>(x,y)))
  
  def scalarProduct(xs:Vector[Int],ys:Vector[Int]):Int= {
  	(xs zip ys).map( x => x._1 * x._2 ).sum
  };System.out.println("""scalarProduct: (xs: Vector[Int], ys: Vector[Int])Int""");$skip(56); val res$3 = 
  
  
  
  scalarProduct(Vector(1,2,3), Vector(4,5,6));System.out.println("""res3: Int = """ + $show(res$3));$skip(68); 
  
  def isPrime(n:Int):Boolean = (2 until n) forall (d => n%d !=0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(17); val res$4 = 
  
  isPrime(17);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(16); 
  
   val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(101); val res$5 = 
  	(1 until n) flatMap ( i => (1 until i) map (j => (i,j))) filter(pair => isPrime(pair._1+pair._2));System.out.println("""res5: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$5))}
  
}
