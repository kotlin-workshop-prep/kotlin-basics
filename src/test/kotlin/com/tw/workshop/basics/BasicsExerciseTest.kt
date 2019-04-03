package com.tw.workshop.basics

import org.junit.Test
import kotlin.test.assertEquals

class BasicsExerciseTest {

    @Test
    fun `should print "One" when input is 1`() {
        BasicsExercise { assertEquals("One", it)}.`when`(1)
    }

    @Test
    fun `should print "Multiple of Ten" when the input is a multiple of 10`() {
        BasicsExercise { assertEquals("Multiple of Ten", it)}.`when`(10)
        BasicsExercise { assertEquals("Multiple of Ten", it)}.`when`(21010)
    }

    @Test
    fun `should print string and its upper case when a string is passed in`() {
        BasicsExercise { assertEquals("String is Foo, upper case is FOO", it)}.`when`("Foo")
    }

    @Test
    fun `should print length of a list when a list is passed in`() {
        BasicsExercise { assertEquals("List length is 4", it)}.`when`(listOf("Alpha", "Beta", "Gamma", "Delta"))
    }

    @Test
    fun `should print "Something else" when none of the above are passed in`() {
        BasicsExercise { assertEquals("Something else", it)}.`when`(Pair(1, "A"))
    }

    @Test
    fun `when no argument is passed in explicitly, the string "Kotlin" should be considered`() {
        BasicsExercise { assertEquals("String is Kotlin, upper case is KOTLIN", it)}.`when`()
    }
}