package org.nilsr.kotlin.examples

/**
 * Shows :
 * - Class inheritance mechanism
 * - Extension function
 */
fun main(args : Array<String>) {
    val firstPerson = Person("GoodOne")
    val secondPerson = BadPerson("BadOne")

    println(firstPerson.name)
    firstPerson.sayHello()
    firstPerson.basicFunction()
    firstPerson.overridableFunction()

    println()
    println(secondPerson.name)
    secondPerson.sayHello()
    secondPerson.basicFunction()
    secondPerson.overridableFunction()
    secondPerson.specificStuff()


    fun Empty.iGotAFunction(){
        println("${this} I am no more empty !!")
    }

    val test = Empty()
    test.iGotAFunction()

}



interface Human {
    val name : String
    fun sayHello()
}

open class Person(override val name : String) : Human{

    override fun sayHello(){ println("Hello") }
    fun basicFunction(){ println("You can't override me !") }
    open fun overridableFunction(){ println("Override me")}

}

class BadPerson(name : String) : Person(name){

    override fun overridableFunction(){println("I override you")}
    override fun sayHello() { println("F**k U") }
    fun specificStuff(){println("Break everything !!!")}
}