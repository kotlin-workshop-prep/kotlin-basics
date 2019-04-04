package com.tw.workshop.classes

class InsufficientBalanceException(message: String) : Exception(message)

abstract class BankAccount(val accountNumber: Long) {

    protected var balance: Int = 0

    fun withdraw(amount: Int): Int {
        if (balance >= amount) {
            balance -= amount
            return amount
        }
        throw InsufficientBalanceException("Not enough Balance")
    }

    fun deposit(amount: Int): Int {
        balance += amount
        return balance
    }

    override fun toString(): String {
        return "BankAccount(accountNumber=$accountNumber, balance=$balance)"
    }
}

class SavingBankAccount(accountNumber: Long) : BankAccount(accountNumber) {
    fun calculateIntrest(rate: Double, time: Double): Double {
        return (balance * rate * time) / 100
    }
}

class CurrentBankAccount(accountNumber: Long) : BankAccount(accountNumber)

fun main(args: Array<String>) {
    val savingBankAccount = SavingBankAccount(123)
    
    savingBankAccount.deposit(5000)
    println(savingBankAccount)

    println(savingBankAccount.calculateIntrest(4.0, 1.0))
    savingBankAccount.withdraw(1200)
    println(savingBankAccount.calculateIntrest(4.0, 1.0))

    val currentBankAccount = CurrentBankAccount(234)
    currentBankAccount.withdraw(123)


}