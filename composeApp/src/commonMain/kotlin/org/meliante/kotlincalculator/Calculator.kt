package org.meliante.kotlincalculator

class Calculator {
    var a: Int = 0
    var b: Int = 0
    var last_operator: String = ""

    fun pressNumber(number: Int): Int {
        if (last_operator == "") {
            a = a * 10 + number
        } else {
            b = b * 10 + number
        }

        return display()
    }

    fun pressClear(): Int {
        a = 0
        b = 0
        last_operator = ""
        return display()
    }

    fun pressEqual(): Int {
        if (last_operator != "") {
            calc()

            last_operator = ""
            b = 0
        }

        return display()
    }

    private fun calc() {
        if (last_operator == "+")
            a += b
        else if (last_operator == "-")
            a -= b
        else if (last_operator == "*")
            a *= b
    }

    fun pressOperator(operator: String): Int {
        if (last_operator == "") {
            last_operator = operator
        } else {
            calc()

            last_operator = operator
            b = 0
        }

        return a
    }

    fun display(): Int {
        if (last_operator == "")
            return a
        return b
    }
}