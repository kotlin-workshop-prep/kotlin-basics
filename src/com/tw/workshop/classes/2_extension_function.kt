package com.tw.workshop.classes

fun main(args: Array<String>) {
    fun Person.getNameLength(): Int {
        println(this)
        return this.name.length
    }

    val person = Person("Bob", 12)
    println(person.getNameLength())
}