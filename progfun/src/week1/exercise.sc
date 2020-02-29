package week1

object exercise {
  def fact(x:Int):Int={
  	
  	def loop(acc:Int,x:Int):Int = {
  		if(x==0) acc
  		else loop(acc * x,x-1)
  	}
  	loop(1,x)
  }                                               //> fact: (x: Int)Int
  
  fact(5)                                         //> res0: Int = 120
}