package com.tw.workshop.functional

/*
- getting the total salary departments wise
- given List of employees find top 5 employees with salary more than 50k and sort them by their name
- given List of employees find top 5 employees with salary more than 50k and keep them in the same order as given
*
* */

data class Employee(
    val name: String,
    val salary: Int,
    val department: String
)

fun main(args: Array<String>) {
    val alice = Employee("Alice", 45000, "Accounts")
    val bob = Employee("Bob", 760000, "Finance")
    val carol = Employee("Carol", 45000, "HR")
    val dan = Employee("Dan", 56000, "IT")
    val erin = Employee("Erin", 156000, "Finance")
    val frank = Employee("Frank", 66000, "Accounts")
    val grace = Employee("Grace", 36000, "IT")
    val ivan = Employee("Ivan", 48000, "HR")

    val employees: List<Employee> = arrayListOf(grace, ivan, alice, frank, bob, carol, dan, erin)

    println(departmentWiseTotalSalary(employees))

    println(first5EmpsWithHighestSalariesSorted(employees))
    println(first5EmpsWithHighestSalariesInOrder(employees))
}

private fun departmentWiseTotalSalary(employees: List<Employee>): Map<String, Int?> {
    return employees.groupingBy { it.department }.aggregate { _, accumulator: Int?, element, first ->
        if (first) element.salary else element.salary + accumulator!!
    }
}

private fun first5EmpsWithHighestSalariesSorted(employees: List<Employee>): List<Employee> {
    return employees.filter { it.salary > 50000 }
        .sortedBy { it.salary }
        .take(5)
        .sortedWith(compareBy { it.name })
}

private fun first5EmpsWithHighestSalariesInOrder(employees: List<Employee>): List<Employee> {
    return employees.filter { it.salary > 50000 }
        .withIndex()
        .sortedBy { (_, e) -> e.salary }
        .take(5)
        .sortedBy { (i, _) -> i }
        .map { (_, s) -> s }
}