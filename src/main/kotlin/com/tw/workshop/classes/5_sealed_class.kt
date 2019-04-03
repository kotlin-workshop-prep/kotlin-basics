package com.tw.workshop.classes

sealed class Expr

class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(expr: Expr): Int {
    return when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
    }
}


fun main(args: Array<String>) {
    val _5 = Num(5)
    val _3 = Num(3)
    val _10 = Num(10)

    val _8 = Sum(_5, _3)

    val sum = Sum(_8, _10)
    println(eval(sum))
}