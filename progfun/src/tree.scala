
sealed abstract class Tree[+T]

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
}

case object End extends Tree[Nothing] {
  override def toString = "."
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object main extends App {
  println(Node('a'))
}

object Tree {
  def cBalanced[T](n: Int, value: T): List[Tree[T]] = n match {
    case n if n < 1 => List(End)
    case n if n % 2 == 1 => {
      val subtrees = cBalanced(n / 2, value)
      println(subtrees)
      subtrees.flatMap { l =>
        println(l)
        subtrees.map(r => Node(value, l, r))
      }
    }
  }
}