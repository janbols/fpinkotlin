package chapter8.solutions.ex9

import chapter8.RNG

typealias TestCases = Int

sealed class Result {
    abstract fun isFalsified(): Boolean
}

object Passed : Result() {
    override fun isFalsified(): Boolean = false
}

typealias SuccessCount = Int
typealias FailedCase = String

data class Falsified(
    val failure: FailedCase,
    val successes: SuccessCount
) : Result() {
    override fun isFalsified(): Boolean = true
}

//tag::init[]
data class Prop(val run: (TestCases, RNG) -> Result) {
    fun and(other: Prop) = Prop { n, rng ->
        when (val result = run(n, rng)) {
            is Passed -> other.run(n, rng)
            is Falsified -> result
        }
    }

    fun or(other: Prop) = Prop { n, rng ->
        when (val result = run(n, rng)) {
            is Falsified ->
                other.tag(result.failure).run(n, rng)
            is Passed -> result
        }
    }

    private fun tag(msg: String) = Prop { n, rng ->
        when (val result = run(n, rng)) {
            is Falsified -> Falsified(
                "$msg: ${result.failure}",
                result.successes
            )
            is Passed -> result
        }
    }
}
//end::init[]
