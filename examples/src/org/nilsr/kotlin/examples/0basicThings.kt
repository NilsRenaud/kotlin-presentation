package org.nilsr.kotlin.examples

import java.util.*

/**
 * Shows :
 * - Variables & functions outside of a class
 * - Type Inference
 * - no more ";"
 * - String Templates
 * - Multi line String
 * - Function definition
 * - Function shortened
 * - val / var
 * - comments format
 * - No basic type
 * - Default value in arguments
 * - Null values management
 */
fun main(args : Array<String>) {

    val sumValue = sum(4,5)
    // "sumValue++" would not compile

    baseValue = addToBaseValue(5)

    println("""Look at my sums :
        - 4 + 5 = $sumValue,
        - 0 + 5 + 1 = ${baseValue.inc()}
    """)
    val test = returnObjectOrNull()

    println(test?.equals(1))
    //test.equals(1) would not compile
    // we can do toto?.child?.parameter?.method() instead of series of if statement
}

var baseValue = 0

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun addToBaseValue(value : Int = 1) = baseValue + value

fun returnObjectOrNull() : Int? = null