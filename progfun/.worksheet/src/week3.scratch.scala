package week3

object scratch {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet");$skip(50); 
  
  def error(msg:String) = throw new Error(msg);System.out.println("""error: (msg: String)Nothing""");$skip(16); 
  
  val x=null;System.out.println("""x  : Null = """ + $show(x ));$skip(22); 
  val y:String = null;System.out.println("""y  : String = """ + $show(y ));$skip(27); val res$0 = 
  
  if(true) 1 else false;System.out.println("""res0: AnyVal = """ + $show(res$0));$skip(28); 
  val l = List(1,2,4,5,7,8);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(11); val res$1 = 
  l.length;System.out.println("""res1: Int = """ + $show(res$1));$skip(43); val res$2 = 
  (2 :: 1 :: "bar" :: "foo" :: Nil).length;System.out.println("""res2: Int = """ + $show(res$2))}
  
}
