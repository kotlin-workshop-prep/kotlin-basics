package com.tw.workshop.basics

class BasicsExercise(private val print: (String) -> Unit = ::print) {
    fun `when`(obj: Any = "Kotlin") {
        when {
            obj == 1 -> print("One")
            obj is Int && obj % 10 == 0 -> print("Multiple of Ten")
            obj is String -> print("String is $obj, upper case is ${obj.toUpperCase()}")
            obj is List<*> -> print("List length is ${obj.size}")
            else -> print("Something else")
        }
    }
}
