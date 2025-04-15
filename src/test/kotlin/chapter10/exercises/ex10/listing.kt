package chapter10.exercises.ex10

import chapter10.Monoid
import utils.SOLUTION_HERE

sealed class WC
data class Stub(val chars: String) : WC()
data class Part(val ls: String, val words: Int, val rs: String) : WC()

//tag::init1[]
fun wcMonoid(): Monoid<WC> = object : Monoid<WC> {
    override fun combine(a1: WC, a2: WC): WC =
    when (a1) {
        is Stub -> when (a2) {
            is Stub ->
                SOLUTION_HERE()
            is Part ->
                SOLUTION_HERE()
        }
        is Part -> when (a2) {
            is Stub ->
                SOLUTION_HERE()
            is Part ->
                SOLUTION_HERE()
        }
    }

override val nil: WC
    get() = SOLUTION_HERE()
//end::init1[]

}
