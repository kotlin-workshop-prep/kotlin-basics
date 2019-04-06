package com.tw.workshop.functional

fun <T> len(list: List<T>): Int {
    return list.map { 1 }.sum()
//    return list.fold(0) { acc, _ -> acc + 1 }
}

fun <T> rejectNulls(list: List<T?>): List<T> {
    return list.filter { it != null }.map { it!! }
}