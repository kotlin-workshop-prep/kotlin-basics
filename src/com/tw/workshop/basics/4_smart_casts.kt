package com.tw.workshop.basics

fun main(args: Array<String>) {
    validateInput("abc")
//    validateInput("de")
//    validateInput(123)
}

private fun validateInput(obj: Any) {
    if (obj is String) {
        println(obj.length)
    } else {
        println("Not a String!")
    }

    if (obj !is String || obj.length < 3) {
        println("Not valid input!")
    }

    if (obj is String && obj.length > 2) {
        println("Valid Input!")
    }
}