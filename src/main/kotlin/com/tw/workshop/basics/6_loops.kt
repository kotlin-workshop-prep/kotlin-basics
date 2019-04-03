package com.tw.workshop.basics

fun main(args: Array<String>) {
    loopCollection()
    loopCollectionWithIndex()
    loopRange()
    loopRangeWithStep()
}

private fun loopRangeWithStep() {
    println("Loop Range with step")
    for (i in 10 downTo 0 step 3) {
        println(i)
    }
    println("")
    println("")
}

private fun loopRange() {
    println("Loop Range")
    for (i in 1..5) {
        println(i)
    }
    println("")
    println("")
}

private fun loopCollectionWithIndex() {
    println("Loop Collections")
    val numbers = listOf(1, 2, 3)
    for ((value, index) in numbers.withIndex()) {
        println(value)
        println(index)
    }
    println("")
    println("")
}

private fun loopCollection() {
    println("Loop Collections")
    val numbers = listOf(1, 2, 3)
    for (i in numbers) println(i)
    println("")
    println("")
}