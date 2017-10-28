package org.nilsr.kotlin.examples

/**
 * Shows :
 * - if/else structure
 * - Object instantiation without "new"
 * - standard librairie helpers functions
 * - for structure
 * - while structure
 * - foreach method
 * - method call without braces
 * - When expression
 * - Multiline function declaration using "="
 * - Using intervals
 * - One liner If/else expression
 */
fun main(args : Array<String>) {
    greaterOrException(1, 2)

    loopOverAListUsingDifferentStyles(listOf("toto", "tata", "tutu"))

    describeUsingWhen(1)

    useInterval(1, 10)
}

fun greaterOrException(lower : Int, greater : Int){
    if(greater > lower){
        println("OK")
    }else{
        throw IllegalStateException()
    }
}

fun loopOverAListUsingDifferentStyles(items : List<*>){
    // Using For loop
    for (item in items){
        println("for loop : $item")
    }

    //Using While loop
    var index = 0
    while (index < items.size) {
        println("while loop : $index, ${items[index]}")
        index++
    }

    // Using Built in List method
    items.forEach { item -> println("built in loop : $item")}
}

fun describeUsingWhen(obj : Any) : String =
    when(obj){
        1           -> "One"
        "Hello"     -> "Greeting"
        is Long     -> "Long"
        !is String  -> "Not a string"
        else        -> "Unknown"
    }

fun useInterval(start : Int, end : Int){
    for (x in start..end step 2) {
        print("$x,")
    }
    println()
    println("2 is ${ if( 2 !in start..end) "not" else "very" } included")

    for (x in end downTo start step 3) {
        print("$x,")
    }


}
