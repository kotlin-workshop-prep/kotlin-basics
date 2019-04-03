package com.tw.workshop.functional

/*
- Write a function to calculate the list of length without using count, size or length operators
- Write a function to calculate sum of the list given a list of numbers
- Write an extension function to implement map
- Write an extension function to implement reduce
* */

fun <T> List<T>.lenRecursive(): Int {
    return when (this) {
        emptyList<T>() -> 0
        else -> 1 + this.drop(1).lenRecursive()
    }
}

fun <T> List<T>.lenReduce(): Int {
    return this.fold(0) { acc: Int, _ -> acc + 1 }
}

fun sumOfNumbers(numbers: List<Int>): Int {
    return when (numbers) {
        emptyList<Int>() -> 0
        else -> numbers[0] + sumOfNumbers(numbers.drop(1))
    }
}

fun <T, R> List<T>.mymap(mapper: (a: T) -> R): List<R> {
    return when (this) {
        emptyList<T>() -> emptyList()
        else -> {
            val mutableList: MutableList<R> = mutableListOf(mapper(this[0]))
            mutableList += this.drop(1).mymap(mapper)
            return mutableList
        }
    }
}

fun <T, R> List<T>.myreduce(acc: R, mapper: (acc: R, elem: T) -> R): R {
    return when (this) {
        emptyList<T>() -> acc
        else -> this.drop(1).myreduce(mapper(acc, this[0]), mapper)
    }
}

fun main(args: Array<String>) {
    val numbers = arrayListOf(1, 2, 3, 5)
    println(numbers.lenRecursive())
    println(numbers.lenReduce())

    val names = arrayListOf("Alice", "Bob", "carol")
    println(names.lenReduce())
    println(names.lenRecursive())
    println(emptyList<Int>().lenReduce())

    println(sumOfNumbers(numbers))
    println(sumOfNumbers(emptyList()))

    println(numbers.mymap { i -> i * i })

    println(numbers.myreduce(0) { acc, elem -> acc + elem })
    println(numbers.myreduce(1) { acc, elem -> acc * elem })
    println(names.myreduce("") { acc, elem -> acc + elem })

}