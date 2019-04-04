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


//Work with list of employees
//1. Output their salaries
//2. Sum their salaries
//3. Sum of salaries of employees in department Accounts
//4.


// Department-wise total salary


private fun departmentWiseTotalSalary(employees: List<Employee>): List<Pair<String, Int>> {
    return employees.groupBy { it.department }.map { Pair(it.key, it.value.map { x -> x.salary }.sum()) };

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