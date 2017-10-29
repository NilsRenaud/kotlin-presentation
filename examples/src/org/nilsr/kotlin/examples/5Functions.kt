package org.nilsr.kotlin.examples

import java.util.*

/**
 * Shows :
 * - Infixe notation usage
 * - Inline keyword
 * - lambda usage examples
 */
fun main(args : Array<String>) {

    val sum = 2 wayBetterAdd 3
    myPrintLn(sum)
    myPrintLn(goToZeroOrOne(1520))

    myPrintLn(applyFunction(1, {x -> x+3}))

    val mySum = {x : Int, y : Int -> x + y}
    println(mySum(3, 4))

    println(
            listOf("abc", "aaaaaa", "bbb")
                    .filter { it.startsWith("a") }
                    .map { it.length }
                    .filter { it > 3 })
}

fun applyFunction(value : Int, functionToCall : (Int)-> Int) : Int{
    println("I call this function")
    return functionToCall(value)
}

infix fun Int.wayBetterAdd(x : Int){
    this + x
}

inline fun myPrintLn(value : Any) = println(value)

// Use recursion with no risk of stack Overflow.
tailrec fun goToZeroOrOne(x: Int): Int
        = if (x in 0..1) x else goToZeroOrOne(x-2)