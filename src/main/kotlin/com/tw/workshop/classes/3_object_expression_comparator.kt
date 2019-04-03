package com.tw.workshop.classes

import java.util.*


fun main(args: Array<String>) {
    val numbers = arrayOf(11, 121, 33)
    Arrays.sort(numbers, object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o1 - o2
        }
    })
    numbers.forEach { println(it) }
}