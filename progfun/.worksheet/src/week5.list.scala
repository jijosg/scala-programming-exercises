package week5

object list {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(174); 

  def init[T](xs: List[T]): List[T] = xs match {
    case List()  => throw new Error("init of empty List")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  };System.out.println("""init: [T](xs: List[T])List[T]""");$skip(133); 

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List()  => ys
    case z :: zs => z :: concat(zs, ys)
  };System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(73); 
  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1);System.out.println("""removeAt: [T](n: Int, xs: List[T])List[T]""");$skip(241); 

  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (Nil, ys)            => ys
    case (xs, Nil)            => xs
    case (x :: xs1, y :: ys1) => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)

  };System.out.println("""merge: (xs: List[Int], ys: List[Int])List[Int]""");$skip(141); 

  def squareList(xs: List[Int]): List[Int] =
    xs match {
      case Nil     => List()
      case y :: ys => y*y :: squareList(ys)
    };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(64); 
  def squareList1(xs: List[Int]): List[Int] = xs map (x => x*x);System.out.println("""squareList1: (xs: List[Int])List[Int]""")}


}
