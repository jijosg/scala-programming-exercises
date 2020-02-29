package week4

import java.util.NoSuchElementException

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false

}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object nth {
  def nth[T](n: Int, l: List[T]): T = {
    if (l.isEmpty) throw new IndexOutOfBoundsException
    if (n == 0) l.head
    else nth(n - 1, l.tail)
  }
}

object List {
  def apply() = new Nil
  def apply[T](x1: T, x2: T) = new Cons(x1, new Cons(x2, new Nil))
}
