package com.tw.workshop.functional

/*
- getting the total salary departments wise
- given List of employees find top 5 employees with salary more than 50k and sort them by their name
- given List of employees find top 5 employees with salary more than 50k and keep them in the same order as given
*
* */

data class OldEmployee(
    val name: String,
    val salary: Int,
    val department: String
)

fun main(args: Array<String>) {
    val alice = OldEmployee("Alice", 45000, "Accounts")
    val bob = OldEmployee("Bob", 760000, "Finance")
    val carol = OldEmployee("Carol", 45000, "HR")
    val dan = OldEmployee("Dan", 56000, "IT")
    val erin = OldEmployee("Erin", 156000, "Finance")
    val frank = OldEmployee("Frank", 66000, "Accounts")
    val grace = OldEmployee("Grace", 36000, "IT")
    val ivan = OldEmployee("Ivan", 48000, "HR")

    val oldEmployees: List<OldEmployee> = arrayListOf(grace, ivan, alice, frank, bob, carol, dan, erin)

    println(departmentWiseTotalSalary(oldEmployees))

    println(first5EmpsWithHighestSalariesSorted(oldEmployees))
    println(first5EmpsWithHighestSalariesInOrder(oldEmployees))
}


//Work with list of employees
//1. Output their salaries
//2. Sum their salaries
//3. Sum of salaries of employees in department Accounts
//4.


// Department-wise total salary


private fun departmentWiseTotalSalary(oldEmployees: List<OldEmployee>): List<Pair<String, Int>> {
    return oldEmployees.groupBy { it.department }.map { Pair(it.key, it.value.map { x -> x.salary }.sum()) };

}

private fun first5EmpsWithHighestSalariesSorted(oldEmployees: List<OldEmployee>): List<OldEmployee> {
    return oldEmployees.filter { it.salary > 50000 }
        .sortedBy { it.salary }
        .take(5)
        .sortedWith(compareBy { it.name })
}

private fun first5EmpsWithHighestSalariesInOrder(oldEmployees: List<OldEmployee>): List<OldEmployee> {
    return oldEmployees.filter { it.salary > 50000 }
        .withIndex()
        .sortedBy { (_, e) -> e.salary }
        .take(5)
        .sortedBy { (i, _) -> i }
        .map { (_, s) -> s }
}