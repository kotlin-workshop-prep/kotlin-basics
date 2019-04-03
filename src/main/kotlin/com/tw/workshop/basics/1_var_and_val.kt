package com.tw.workshop.basics

fun main(args: Array<String>) {

    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var sum = 0

    for (number in numbers) {
        sum += number;
    }

    println(sum)
}