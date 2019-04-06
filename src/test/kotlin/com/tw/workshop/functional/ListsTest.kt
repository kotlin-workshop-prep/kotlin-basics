package com.tw.workshop.functional

import org.junit.Test
import kotlin.test.assertEquals

class ListsTest {
    @Test
    fun shouldGiveLengthOfListOfNumbers() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertEquals(5, len(numbers))
    }

    @Test
    fun shouldGiveLengthOfListOfStrings() {
        val numbers = listOf("Alice", "Bob", "Carol", "Ryan")
        assertEquals(4, len(numbers))
    }

    @Test
    fun shouldFilterOutAllNullStrings() {
        val names = listOf("Alice", null, "Bob", null, "Harry", "Carol", null)
        val expected = listOf("Alice", "Bob", "Harry", "Carol")

        val actual: List<String> = rejectNulls(names)
        assertEquals(expected, actual)
    }

    @Test
    fun shouldFilterOutAllNullIntValues() {
        val numbers = listOf(1, null, 2, null, 3, 4, null)
        val expected = listOf(1, 2, 3, 4)

        val actual: List<Int> = rejectNulls(numbers)
        assertEquals(expected, actual)
    }
}