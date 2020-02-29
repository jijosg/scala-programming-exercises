package week5

object list {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def init[T](xs: List[T]): List[T] = xs match {
    case List()  => throw new Error("init of empty List")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List()  => ys
    case z :: zs => z :: concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]
  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]

  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (Nil, ys)            => ys
    case (xs, Nil)            => xs
    case (x :: xs1, y :: ys1) => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)

  }                                               //> merge: (xs: List[Int], ys: List[Int])List[Int]

  def squareList(xs: List[Int]): List[Int] =
    xs match {
      case Nil     => List()
      case y :: ys => y*y :: squareList(ys)
    }                                             //> squareList: (xs: List[Int])List[Int]
  def squareList1(xs: List[Int]): List[Int] = xs map (x => x*x)
                                                  //> squareList1: (xs: List[Int])List[Int]


}