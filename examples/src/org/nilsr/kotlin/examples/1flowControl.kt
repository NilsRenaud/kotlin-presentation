package org.nilsr.kotlin.examples

/**
 * Shows :
 * - if structure
 */
fun main(args : Array<String>) {


    val sumValue = sum(4, 5)
    var betterSumValue = addToBaseValue(5, 5)
    betterSumValue++
    // "sumValue++" would not compile

    println("""Look at my sums :
        - Sum Value: $sumValue,
        - Better Sum Value : $betterSumValue
    """)
}
