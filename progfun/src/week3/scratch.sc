package week3

object scratch {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def error(msg:String) = throw new Error(msg)    //> error: (msg: String)Nothing
  
  val x=null                                      //> x  : Null = null
  val y:String = null                             //> y  : String = null
  
  if(true) 1 else false                           //> res0: AnyVal = 1
  val l = List(1,2,4,5,7,8)                       //> l  : List[Int] = List(1, 2, 4, 5, 7, 8)
  l.length                                        //> res1: Int = 6
  (2 :: 1 :: "bar" :: "foo" :: Nil).length        //> res2: Int = 4
  
}