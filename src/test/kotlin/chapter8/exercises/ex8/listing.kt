package chapter8.exercises.ex8

import chapter8.RNG
import chapter8.State
import utils.SOLUTION_HERE
import kotlin.math.absoluteValue

data class Gen<A>(val sample: State<RNG, A>) {
    companion object {

        //tag::init[]
        fun <A> weighted(
            pga: Pair<Gen<A>, Double>,
            pgb: Pair<Gen<A>, Double>
        ): Gen<A> {
            val (ga, p1) = pga
            val (gb, p2) = pgb
            val prob =
                p1.absoluteValue /
                        (p1.absoluteValue + p2.absoluteValue)

            SOLUTION_HERE()
        }
        //end::init[]
    }

    fun <B> flatMap(f: (A) -> Gen<B>): Gen<B> =
        Gen(sample.flatMap { a -> f(a).sample })
}
