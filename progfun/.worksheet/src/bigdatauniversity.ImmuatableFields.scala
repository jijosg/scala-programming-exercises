package bigdatauniversity


object ImmuatableFields {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(97); 
  println("Welcome to the Scala worksheet");$skip(34); 

  val car = new Car("automatic");System.out.println("""car  : bigdatauniversity.Car = """ + $show(car ));$skip(36); 
  car.color("White","Beige","Blue");$skip(40); 
  val car1 = car.printTransmission(car);System.out.println("""car1  : Unit = """ + $show(car1 ));$skip(19); val res$0 = 
  car.transmission;System.out.println("""res0: String = """ + $show(res$0));$skip(42); val res$1 = 
  
  CreateTime.createTimeFromMinutes(10);System.out.println("""res1: Int = """ + $show(res$1));$skip(17); val res$2 = 
  
  (new Hello);System.out.println("""res2: bigdatauniversity.Hello = """ + $show(res$2));$skip(23); 
	val time  = Time(9,0);System.out.println("""time  : bigdatauniversity.Time = """ + $show(time ));$skip(17); val res$3 = 
	time == Time(9);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(15); val res$4 = 
	time.toString;System.out.println("""res4: String = """ + $show(res$4))}
}

class Car(val transmission:String) {
  def printTransmission(c:Car){
  	println(c.transmission)
  }
  def color(exterior:String, console:String, interior:String="Black"){
  	println(exterior + " " + console + " " + interior)
  }
}

object CreateTime{
	val oneMinuteInSeconds = 60
	
	def createTimeFromMinutes(minutes:Int):Int = {
		minutes*oneMinuteInSeconds
	}
}



object Hello{
	private val defaultmessage:String = "Hello"
}

class Hello(message:String = Hello.defaultmessage){
	println(message)
}

case class Time(hours:Int = 0, minutes:Int = 0)
