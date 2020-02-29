package week2

object exercise {

def mapReduce(f:Int=>Int,combine:(Int,Int)=>Int, zero:Int)(a:Int,b:Int):Int =
	if(a>b) zero
 else combine(f(a),mapReduce(f,combine,zero)(a=1,b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a>b)acc
    else loop(a+1,f(a)+acc)
  }
  loop(a,0)
}                                                 //> sum: (f: Int => Int)(a: Int, b: Int)Int

sum(x => x*x)(3,5)                                //> res0: Int = 50



def product(f:Int=>Int)(a:Int,b:Int):Int = {
	if(a>b) 1 else f(a) * product(f)(a+1,b)
}                                                 //> product: (f: Int => Int)(a: Int, b: Int)Int

def fact(n:Int):Int = product(x => x)(1,n)        //> fact: (n: Int)Int

product(x=>x*x)(3,5)                              //> res1: Int = 3600

fact(5)                                           //> res2: Int = 120



}