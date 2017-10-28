package org.nilsr.kotlin.examples

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
 */
fun main(args : Array<String>) {

    val sumValue = sum(4,5)
    // "sumValue++" would not compile

    baseValue = addToBaseValue(5)

    println("""Look at my sums :
        - 4 + 5 = $sumValue,
        - 0 + 5 + 1 = ${baseValue.inc()}
    """)
}

var baseValue = 0

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun addToBaseValue(value : Int) = baseValue + value