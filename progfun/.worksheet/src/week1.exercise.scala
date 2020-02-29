package week1

object exercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(161); 
  def fact(x:Int):Int={
  	
  	def loop(acc:Int,x:Int):Int = {
  		if(x==0) acc
  		else loop(acc * x,x-1)
  	}
  	loop(1,x)
  };System.out.println("""fact: (x: Int)Int""");$skip(13); val res$0 = 
  
  fact(5);System.out.println("""res0: Int = """ + $show(res$0))}
}
