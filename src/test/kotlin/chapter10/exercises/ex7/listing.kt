package chapter10.exercises.ex7

import chapter10.Monoid
import chapter10.solutions.ex7.foldMap
import chapter10.stringMonoid
import chapter7.sec4_4.splitAt
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

//tag::init1[]
fun <A, B> foldMap(la: List<A>, m: Monoid<B>, f: (A) -> B): B =
    when {
        la.size >= 2 -> {
            SOLUTION_HERE()
        }
        la.size == 1 ->
            f(la.first())
        else -> m.nil
    }
//end::init1[]

//TODO: Enable tests by removing `!` prefix
class Exercise7 : WordSpec({
    "balanced folding foldMap" should {
        "fold a list with an even number of values" {
            foldMap(
                listOf("lorem", "ipsum", "dolor", "sit"),
                stringMonoid
            ) { it } shouldBe "loremipsumdolorsit"
        }
        "fold a list with an odd number of values" {
            foldMap(
                listOf("lorem", "ipsum", "dolor"),
                stringMonoid
            ) { it } shouldBe "loremipsumdolor"
        }
        "fold a list with a single value" {
            foldMap(
                listOf("lorem"),
                stringMonoid
            ) { it } shouldBe "lorem"
        }
        "fold an empty list" {
            foldMap(
                emptyList<String>(),
                stringMonoid
            ) { it } shouldBe ""
        }
    }
})
