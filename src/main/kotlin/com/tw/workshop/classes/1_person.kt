package com.tw.workshop.classes

data class User(var name: String){
    var password: String = ""

    override fun equals(other: Any?): Boolean {
        return other is User && name == other.name && password == other.password
    }
}

class Person(nameParam: String, ageParam: Int) {
    var name: String = nameParam
        set(value) {
            if (value.length < 3) {
                throw IllegalArgumentException("Name should atleast contain 3 characters")
            }
            field = value
        }

    private var age: Int = ageParam

    fun isAdult(): Boolean = age >= 18

    override fun toString(): String = "Person(name=$name, age=$age)"
}


/*
    * We can define properties in the primary constructor
    * Default visibility is `public` for all the properties.
    * Getters and Setters are automatically generated, All the interaction happen using getters and setters
    * To define our own getters/setters we need to define properties outside of primary constructor
    * We can choose getter and setter to be private
    * We can make the properties `private` but then we cannot use getters and setters around them, however we can have other behaviours for them
    * We can override a function by putting keyword override before that
    * We can create data classes which will have equals,hashcode, toString
* */
fun main(args: Array<String>) {
    val person = Person("Ryan", 12)
    person.name = "Bob"
    println(person.name)
    println(person.isAdult())
    println(person)

    println("*******************************")
    val user1 = User("bob")
    println(user1)
    user1.password = "xyz"
    val user2 = User("bob")
    user2.password = "abc"

    println(user1 == user2)
}