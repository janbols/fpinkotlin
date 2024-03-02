package chapter2.sec1

//tag::init3[]
object Example {

    private fun abs(n: Int): Int =
        if (n < 0) -n
        else n

    private fun factorial(i: Int): Int { //<1>
        fun go(n: Int, acc: Int): Int =
            if (n <= 0) acc
            else go(n - 1, n * acc)
        return go(i, 1)
    }

    fun formatAbs(x: Int): String {
        val msg = "The absolute value of %d is %d"
        return msg.format(x, abs(x))
    }

    fun formatFactorial(x: Int): String { //<2>
        val msg = "The factorial of %d is %d"
        return msg.format(x, factorial(x))
    }

    fun formatResult(): String = TODO()
}

fun main() {
    println(Example.formatAbs(-42))
    println(Example.formatFactorial(7)) //<3>
}
