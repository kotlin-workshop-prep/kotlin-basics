package com.tw.workshop.functional

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class OrganizationTest {
    val accountsDepartment = Department("Accounts")
    val financeDepartment = Department("Finance")
    val hrDepartment = Department("HR")
    val itDepartment = Department("IT")


    val alice = Employee("Alice", 45000, accountsDepartment)
    val bob = Employee("Bob", 76000, financeDepartment)
    val carol = Employee("Carol", 45000, hrDepartment)
    val dan = Employee("Dan", 56000, itDepartment)
    val erin = Employee("Erin", 156000, financeDepartment)
    val frank = Employee("Frank", 66000, accountsDepartment)
    val grace = Employee("Grace", 36000, itDepartment)
    val ivan = Employee("Ivan", 48000, hrDepartment)

    val employees = listOf(alice, bob, carol, dan, erin, frank, grace, ivan)

    @Test
    fun shouldGiveTheirSalaries() {
        val expected = listOf(45000, 76000, 45000, 56000, 156000, 66000, 36000, 48000)

        assertEquals(expected, getSalariesOfEmployees(employees))
    }

    @Test
    fun shouldGiveSumOfAllSalaries() {
        assertEquals(528000, getTotalSalariesOfAllEmployees(employees))
    }

    @Test
    fun shouldGiveTotalSalaryForGivenDepartment() {
        assertEquals(111000, getTotalSalariesForDepartment(employees, accountsDepartment))
        assertEquals(92000, getTotalSalariesForDepartment(employees, itDepartment))
    }

    @Test
    fun shouldGiveEachDepartmentTotalSalary() {
        val accountsSalary = Pair(accountsDepartment, 111000)
        val hrSalary = Pair(hrDepartment, 93000)
        val itSalary = Pair(itDepartment, 92000)
        val financeSalary = Pair(financeDepartment, 232000)

        val expected = listOf(accountsSalary, financeSalary, hrSalary, itSalary)

        val actual = getEachDepartmentTotalSalary(employees)
        assertTrue(actual.containsAll(expected))
    }

    @Test
    fun shouldGiveAllDepartmentsForGivenEmployees() {
        val expected = listOf(accountsDepartment, hrDepartment, itDepartment, financeDepartment)
        val actual = getAllDepartment(employees)
        assertTrue(actual.size == expected.size
                && actual.containsAll(expected)
                && expected.containsAll(actual))

    }
}

