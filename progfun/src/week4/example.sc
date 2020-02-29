package week4

object example {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}

trait Expr{
	def isNumber:Boolean
	def isSum:Boolean
	def numValue: Int
	def leftOp: Expr
	def rightOp: Expr
}

class Number(n:Int) extends Expr{
	def isNumber:Boolean = true
	def isSum:Boolean = false
	def numValue: Int = n
	def leftOp: Expr = throw new Error("operation on number")
	def rightOp: Expr = throw new Error("operation on number")
}

class Sum(e1:Expr,e2:Expr) extends Expr{
	def isNumber:Boolean = false
	def isSum:Boolean = true
	def numValue:Int = throw new Error("Sum.numValue")
	def leftOp: Expr = e1
	def rightOp: Expr = e2
	
	def eval(e:Expr):Int = {
		if(e.isNumber) e.numValue
		else if(e.isSum) eval(e.leftOp) + eval(e.rightOp)
		else throw new Error("No such expression")
	}
}