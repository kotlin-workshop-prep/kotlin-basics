package com.tw.workshop.functional

class Employee(
        val name: String,
        var salary: Int,
        val department: Department
)

class Department(val name: String) {
}

fun getSalariesOfEmployees(employees: List<Employee>): List<Int> {
    return employees.map { it.salary }
}

fun getTotalSalariesOfAllEmployees(employees: List<Employee>): Int {
    return employees.fold(0) { total, employee -> total + employee.salary }
}

fun getTotalSalariesForDepartment(employees: List<Employee>, department: Department): Int {
    return employees
            .filter { it.department == department }
            .fold(0) { total, employee -> total + employee.salary }
}

fun getEachDepartmentTotalSalary(employees: List<Employee>): List<Pair<Department, Int>> {
    return employees
            .groupBy { it.department }
            .map { (dept, deptEmps) ->
                val totalForDept = deptEmps.fold(0) { acc, employee -> acc + employee.salary }
                Pair(dept, totalForDept)
            }
}

fun getAllDepartment(employees: List<Employee>): List<Department> {
    return employees.map { it.department }
            .distinct()
}