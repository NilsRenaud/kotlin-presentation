package org.nilsr.kotlin.examples

import java.util.*

/**
 * Shows :
 * - Object as anonymous class
 * - declared Objects as Singletons
 * - Companions objects used as factory
 * - Built in Delegation over inheritance using By
 */
fun main(args : Array<String>) {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    println(adHoc.x + adHoc.y)

    DataProviderManager.registerDataProvider(DataProvider())
    println(DataProviderManager.allDataProviders.size)

    val createdObject = ObjectHardToCreate.create()

    val b = BaseImpl(10)
    Derived(b, "test").print()
}

class DataProvider

object DataProviderManager {
    private val dataProviders = LinkedList<DataProvider>()
    fun registerDataProvider(provider: DataProvider) {
        dataProviders.add(provider)
    }

    val allDataProviders: Collection<DataProvider>
        get() = dataProviders
}


class ObjectHardToCreate {
    companion object Factory {
        fun create() = ObjectHardToCreate()
    }
}

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base, otherVal : String) : Base by b
