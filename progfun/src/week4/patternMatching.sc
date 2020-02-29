package week4

object patternMatching {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}

trait Expr {
  def eval: Int = this match {
    case Number(n)   => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }

}
object exprs {
  def show(e: Expr): String = e match {
    case Number(n)   => n.toString()
    case Sum(e1, e2) => show(e1) + " " + show(e2)
  }
}
case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr