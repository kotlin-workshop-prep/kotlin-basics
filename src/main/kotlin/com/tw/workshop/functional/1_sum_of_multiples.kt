package com.tw.workshop.functional

//https://exercism.io/tracks/kotlin/exercises/sum-of-multiples/solutions/4993d90cb4c84e9fa29b9cf5f54d6af7

fun sumOfMultiplesOf(multiplesOf: Array<Int>, n: Int): Int {
    return multiplesOf.flatMap {
        (0 until n).step(it)
    }.distinct().sum()
}

fun main(args: Array<String>) {
    println(sumOfMultiplesOf(arrayOf(3, 5), 1000))
}

fun foo(n: Int): Int {
    return (1..Int.MAX_VALUE).filter { it % 3 == 0 || it % 5 == 0 }.takeWhile { it < 1000 }.sum()
}


//

