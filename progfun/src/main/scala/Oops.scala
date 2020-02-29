package main.scala

class Vehicle{
	private var speed = 0

	def accelerate(speed:Int):Int = {
		this.speed += speed
		this.speed
	}

	def decelerate(speed:Int):Int = {
		if(this.speed-speed <0){
			throw new Error("Cannot reduce speed")
		}else{
			this.speed-= speed
		}
		this.speed
	}
	def currentSpeed = this.speed
}

class Car(name:String) extends Vehicle{
	def getName:String = name
}

object Temp extends App{
	val car = new Car("benz")
	println(car.getName)
	println(car.accelerate(100))
	println(car.currentSpeed)
	println(car.decelerate(200))
}