package bigdatauniversity


object ImmuatableFields {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val car = new Car("automatic")                  //> car  : bigdatauniversity.Car = bigdatauniversity.Car@6a5fc7f7
  car.color("White","Beige","Blue")               //> White Beige Blue
  val car1 = car.printTransmission(car)           //> automatic
                                                  //| car1  : Unit = ()
  car.transmission                                //> res0: String = automatic
  
  CreateTime.createTimeFromMinutes(10)            //> res1: Int = 600
  
  (new Hello)                                     //> Hello
                                                  //| res2: bigdatauniversity.Hello = bigdatauniversity.Hello@880ec60
	val time  = Time(9,0)                     //> time  : bigdatauniversity.Time = Time(9,0)
	time == Time(9)                           //> res3: Boolean = true
	time.toString                             //> res4: String = Time(9,0)
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