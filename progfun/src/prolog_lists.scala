object prolog_lists {

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 46, 77)
    println("\nlast(List(1, 2, 46, 77)) : \n" + last(List(1, 2, 46, 77)))
    println("\nlast(List('1','asfasdf')) : \n" + last(List("1", "asfasdf")))
    println("\nlast(List(9)) : \n" + last(List(9)))

    println("\nlastButOne(List(1, 2, 46, 77)) : \n" + lastButOne(List(1, 2, 46, 77)))
    println("\nlastButOne(\"asfasdf\".toList) : \n" + lastButOne("asfasdf".toList))
    println("\nlastButOne(List(9.0,10.0,11.10)) : \n" + lastButOne(List(9.0, 10.0, 11.10)))

    println("\nkthElement(2,List(9.0, 10.0, 11.10)) : \n" + kthElement(1, List(9.0, 10.0, 11.10)))

    println(list.foldLeft(0)((c, _) => c + 1))

    println("\nList('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) : \n" + compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println("\nreverseList(List(1, 2, 46, 77)) : \n" + reverseList(List(1, 2, 46, 77)))
    println("\nisPalindrome(List(2, 3, 3, 2)) : \n" + isPalindrome(List(2, 3, 3, 2)))

    println("\nflatten(List(List(1, 1), 2, List(3, List(5, 8)))) : \n" + flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
    println("\npack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) : \n" + pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println("\nencode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) : \n" + encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println("\nencodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) : \n" + encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

    println("\ndecode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) : \n" + decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
    println("\nduplicate(List('a,'b,'c)) :\n" + duplicate(List('a, 'b, 'c)))
    println("\nduplicateN(4)(List('a,'b,'c)) :\n" + duplicateN(4)(List('a, 'b, 'c)))
    println("\ndrop(4, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) :\n" + drop(4, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def call = println("\nScala call");

  def last[A](l: List[A]): A = l match {
    case Nil      => throw new Error("Empty list")
    case x :: Nil => x
    case h :: t   => last(t)

  }

  def lastButOne[A](l: List[A]): A = l match {
    case Nil         => throw new Error("Empty list")
    case x :: Nil    => throw new Error("Only one element in list")
    case x :: y :: z => if (z == Nil) x else lastButOne(l.tail)
  }

  def kthElement[A](n: Int, l: List[A]): A = (n, l) match {
    case (_, Nil)       => throw new NoSuchElementException
    case (0, h :: _)    => h
    case (n, _ :: tail) => kthElement(n - 1, tail)
  }

  def compress[A](l: List[A]): List[A] = l match {
    case Nil       => Nil
    case h :: tail => h :: compress(tail.dropWhile { x => x == h })
  }

  def reverseList[A](l: List[A]): List[A] = l.foldLeft(List[A]())((x, y) => y :: x)

  def isPalindrome[A](l: List[A]): Boolean = l == l.reverse

  def flatten[A](l: List[Any]): List[Any] = l flatMap {
    case ms: List[_] => flatten(ms)
    case e           => List(e)
  }

  // pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  def pack[A](xs: List[A]): List[List[A]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
    }
  }
  //encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  def encode[A](xs: List[A]): List[(Int, A)] = {
    pack(xs) map (ys => (ys.length, ys.head))
  }

  def encodeModified[A](xs: List[A]): List[Any] = {
    encode(xs) map (ys => if (ys._1 == 1) ys._2 else ys)
  }

  def decode[A](xs: List[(Int, A)]): List[A] = {
    xs flatMap { e => List.fill(e._1)(e._2) }
  }

  def duplicate[A](l: List[A]): List[A] = l flatMap { x => List(x, x) }
  def duplicateN[A](n: Int)(l: List[A]): List[A] = l flatMap { x => List.fill(n)(x) }

  //drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  def drop[A](n: Int, l: List[A]): List[A] =
    l.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map (_._1)
}