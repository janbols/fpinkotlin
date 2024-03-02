package chapter2.sec1

    //tag::init1[]
    fun factorial(i: Int): Int {
        fun go(n: Int, acc: Int): Int = // <1>
            if (n <= 0) acc
            else go(n - 1, n * acc)
        return go(i, 1) // <2>
    }
    //end::init1[]


fun main() {
    println(factorial(3))
}
