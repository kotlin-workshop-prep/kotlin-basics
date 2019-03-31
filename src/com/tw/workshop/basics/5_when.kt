package com.tw.workshop.basics

fun main(args: Array<String>) {
    `when`(1)
    `when`(2)
    `when`(7)
    `when`("Bob")
    `when`(20)
    `when`(40.9)
}

private fun `when`(obj: Any) {
    val validNumbers: Array<Number> = arrayOf(20, 30, 40, 50)
    when (obj) {
        1 -> println("Got one")
        2, 4 -> println("Either 2 or 4")
        6..10 -> println("Between 6 to 10")
        is String -> println("Got a string")
        in validNumbers -> println("Is a valid Number")
        else -> println("None of the above ")
    }
}