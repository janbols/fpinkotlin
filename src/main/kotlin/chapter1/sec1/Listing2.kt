package chapter1.sec1

val listing2 = {
    data class Coffee(val price: Float = 2.95F)

    class CreditCard

    class Payments {
        fun charge(cc: CreditCard, price: Float): Unit = TODO()
    }

    //tag::init2[]
    class Cafe {
        fun buyCoffee(cc: CreditCard, p: Payments): Coffee {
            val cup = Coffee()
            p.charge(cc, cup.price)
            return cup
        }
    }
    //end::init2[]
}
