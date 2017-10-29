package org.nilsr.kotlin.examples

import javax.naming.OperationNotSupportedException

/**
 * Shows :
 * - Data class definition
 * - Data class fields definition using var/val
 * - Data class auto generated methods
 * - Operator overloads
 * - Data class components auto-definition
 * - Class definition
 * - Constructor definition
 * - Init method
 * - public/private fields
 * - Specific getters and setters
 * - Lazy evaluation
 * - Enums
 */
fun main(args : Array<String>) {
    val rect = Rectangle(1, 2)
    val rect2 = Rectangle(1, 2)
    // "rect.length = 1" does not compile

    println("${rect.length}, ${rect.width}")
    println(rect == rect2)


    val rectMut = MutableRectangle(1, 2)
    rectMut.length = 4

    println("${rectMut.component1()}, ${rectMut.component2()}")

    // Example of an empty class instantiation
    val empty = Empty()

    // Example of a Customer Instantiation
    var customer = Customer("Nils", "Test", "privateVal")
    println("${customer.customerKey} : ${customer.firstName} ${customer.lastName}")
    // customer.age & customer.privateField are not reachable.

    customer = Customer("Nils")
    println("$customer has name ? ${customer.hasAName}")


}

data class Rectangle(val width : Int, val length : Int)
data class MutableRectangle(var width : Int, var length : Int)
class Empty
class Customer(val firstName: String, val lastName: String?, privateField: String) {
    val customerKey = lastName?.toUpperCase()
    private val age : Int

    constructor(firstname : String) : this(firstname, null, "secret"){
        //Some Stuff
    }

    init {
        age = 0
        println("$customerKey : $privateField")
    }

    var hasAName: Boolean
        get() = this.lastName == null
        set(value) {
            throw OperationNotSupportedException()
        }

    val lazyField : String by lazy { println("should be printed only once"); "lazyValue" }
}

enum class Color(val red : Int, val green : Int, val blue : Int){
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255)
}


enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}