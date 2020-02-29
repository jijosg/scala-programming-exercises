
object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(48); 
  val x = new Rational(1, 3);System.out.println("""x  : Rational = """ + $show(x ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(31); 
  
  val y = new Rational(5,7);System.out.println("""y  : Rational = """ + $show(y ));$skip(28); 
  val z = new Rational(3,2);System.out.println("""z  : Rational = """ + $show(z ));$skip(15); val res$2 = 
  
  x - y - z;System.out.println("""res2: Rational = """ + $show(res$2));$skip(8); val res$3 = 
  y + y;System.out.println("""res3: Rational = """ + $show(res$3));$skip(7); val res$4 = 
  x< y;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(10); val res$5 = 
  x max y;System.out.println("""res5: Rational = """ + $show(res$5));$skip(18); val res$6 = 
  new Rational(2);System.out.println("""res6: Rational = """ + $show(res$6))}


}

class Rational(x: Int, y: Int) {

	require(y!=0,"denominator must be a non zero")
	private def gcd(a:Int,b:Int) :Int = if(b==0) a else gcd(b,a%b)
  def numer = x
  def denom = y
  
  def this(x:Int) = this(x,1)
  
  def < (that:Rational) = numer * that.denom < that.numer * denom
  
  def max(that:Rational) = if(this < that) that else this
  
  def +(number:Rational) =
  	new Rational(numer * number.denom + denom * number.numer, denom * number.denom)
  	
  override def toString ={
  	val g = gcd(numer,denom)
  	numer/g +"/"+denom/g
  }
 	def unary_- :Rational = new Rational(-numer,denom)
 	
 	def -(number:Rational) = this + -number
  
 	
  
}
