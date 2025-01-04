package chapter8.exercises.ex6

import chapter8.RNG
import chapter8.State
import chapter8.solutions.ex6.Gen
import utils.SOLUTION_HERE

//tag::init[]
data class Gen<A>(val sample: State<RNG, A>) {

    companion object {
        fun <A> listOfN(n: Int, ga: Gen<A>): Gen<List<A>> =
            Gen(State.sequence(List(n) { ga.sample }))

        fun <A> listOfN(gn: Gen<Int>, ga: Gen<A>): Gen<List<A>> =

            SOLUTION_HERE()
    }

    fun <B> flatMap(f: (A) -> Gen<B>): Gen<B> =

        SOLUTION_HERE()
}
//end::init[]
