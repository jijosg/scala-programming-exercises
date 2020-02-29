object prolog_lists {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(234); 

  def last(l: List[Int]): Int = l match {
    case Nil =>
      { println("case Nil"); throw new Error("Empty list") }
    case x :: Nil => x
    case h :: t =>
      { println("case h::t" + t); last(t) }

  };System.out.println("""last: (l: List[Int])Int""");$skip(34); 

  val list = List(1, 2, 46, 77);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(15); val res$0 = 
  last(List());System.out.println("""res0: Int = """ + $show(res$0))}

}
