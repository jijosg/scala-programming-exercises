package week5

object listfun {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  val nums = List(2, 2,-4,3,3, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
  val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(26); val res$0 = 
  nums.filter(x => x > 0);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(32); val res$1 = 

  nums partition (x => x > 0);System.out.println("""res1: (List[Int], List[Int]) = """ + $show(res$1));$skip(34); val res$2 = 

  nums takeWhile { x => x > 0 };System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(32); val res$3 = 
  nums dropWhile { x => x > 0 };System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(27); val res$4 = 
  nums span { x => x > 0 };System.out.println("""res4: (List[Int], List[Int]) = """ + $show(res$4));$skip(184); 

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
    }
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(53); 
  val data = List("a", "a", "a", "b", "c", "c", "a");System.out.println("""data  : List[String] = """ + $show(data ));$skip(10); val res$5 = 
  data(1);System.out.println("""res5: String = """ + $show(res$5));$skip(13); val res$6 = 
  pack(data);System.out.println("""res6: List[List[String]] = """ + $show(res$6));$skip(99); 
  def encode[T](xs: List[T]): List[(T, Int)] = {
    pack(xs) map (ys => (ys.head, ys.length))
  };System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(21); val res$7 = 
  encode(pack(data));System.out.println("""res7: List[(List[String], Int)] = """ + $show(res$7));$skip(57); 

  def sum(xs: List[Int]): Int = (xs foldLeft 0)(_ + _);System.out.println("""sum: (xs: List[Int])Int""");$skip(42); val res$8 = 
  sum(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));System.out.println("""res8: Int = """ + $show(res$8));$skip(81); 

  def concat[T](xs: List[T], ys: List[T]): List[T] = (xs foldRight ys)(_ :: _);System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(54); val res$9 = 

  concat(List(1, 2, 3, 4, 5, 6, 7, 8, 9), List(10));System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(106); 

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())((x, y) => f(x) :: y);System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(79); 

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((x, y) => 1 + y);System.out.println("""lengthFun: [T](xs: List[T])Int""");$skip(20); val res$10 = 

  lengthFun(data);System.out.println("""res10: Int = """ + $show(res$10));$skip(30); 
  val list = List(1, 2, 3, 4);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(45); val res$11 = 
  mapFun[Int, String](list, x => x + "some");System.out.println("""res11: List[String] = """ + $show(res$11))}
}
