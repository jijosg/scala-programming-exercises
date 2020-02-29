package week5

object listfun {
  val nums = List(2, 2,-4,3,3, 5, 7, 1)           //> nums  : List[Int] = List(2, 2, -4, 3, 3, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  nums.filter(x => x > 0)                         //> res0: List[Int] = List(2, 2, 3, 3, 5, 7, 1)

  nums partition (x => x > 0)                     //> res1: (List[Int], List[Int]) = (List(2, 2, 3, 3, 5, 7, 1),List(-4))

  nums takeWhile { x => x > 0 }                   //> res2: List[Int] = List(2, 2)
  nums dropWhile { x => x > 0 }                   //> res3: List[Int] = List(-4, 3, 3, 5, 7, 1)
  nums span { x => x > 0 }                        //> res4: (List[Int], List[Int]) = (List(2, 2),List(-4, 3, 3, 5, 7, 1))

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
    }
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)
  data(1)                                         //> res5: String = a
  pack(data)                                      //> res6: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 
  def encode[T](xs: List[T]): List[(T, Int)] = {
    pack(xs) map (ys => (ys.head, ys.length))
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]
  encode(pack(data))                              //> res7: List[(List[String], Int)] = List((List(a, a, a),1), (List(b),1), (List
                                                  //| (c, c),1), (List(a),1))

  def sum(xs: List[Int]): Int = (xs foldLeft 0)(_ + _)
                                                  //> sum: (xs: List[Int])Int
  sum(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))         //> res8: Int = 45

  def concat[T](xs: List[T], ys: List[T]): List[T] = (xs foldRight ys)(_ :: _)
                                                  //> concat: [T](xs: List[T], ys: List[T])List[T]

  concat(List(1, 2, 3, 4, 5, 6, 7, 8, 9), List(10))
                                                  //> res9: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())((x, y) => f(x) :: y) //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((x, y) => 1 + y)             //> lengthFun: [T](xs: List[T])Int

  lengthFun(data)                                 //> res10: Int = 7
  val list = List(1, 2, 3, 4)                     //> list  : List[Int] = List(1, 2, 3, 4)
  mapFun[Int, String](list, x => x + "some")      //> res11: List[String] = List(1some, 2some, 3some, 4some)
}