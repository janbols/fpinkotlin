package chapter1.sec1

val listing3 = {

    class CreditCard

    data class Coffee(val price: Float = 2.50F)

    data class Charge(val cc: CreditCard, val amount: Float)

    //tag::init3[]
    class Cafe {
        fun buyCoffee(cc: CreditCard): Pair<Coffee, Charge> {
            val cup = Coffee()
            return Pair(cup, Charge(cc, cup.price))
        }
    }
    //end::init3[]
}
