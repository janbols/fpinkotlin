package chapter1.sec1

val listing6 = {

    class CreditCard

    data class Charge(val cc: CreditCard, val amount: Float) {
        fun combine(other: Charge): Charge = TODO()
    }

    //tag::init6[]
    fun List<Charge>.coalesce(): List<Charge> =
        this.groupBy { it.cc }.values
            .map { it.reduce { a, b -> a.combine(b) } }
    //end::init6[]
}
