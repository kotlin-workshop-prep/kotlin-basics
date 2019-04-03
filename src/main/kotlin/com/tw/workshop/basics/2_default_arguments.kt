package com.tw.workshop.basics


fun main(args: Array<String>) {
    println(fullName("Ryan ", "Harris"))
    println(fullName(second = "Harris"))
    println(fullName(first = "Ryan "))
    println(fullName())
}

fun fullName(first: String = "Bob ", second: String = "Willis"): String {
    return first + second
}