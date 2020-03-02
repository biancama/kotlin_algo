import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotlintest.matchers.collections.shouldNotContain
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec;
class ApartmentTest : FunSpec() {
    init {

        testCalculatePossibleSolution01()
        testCalculatePossibleSolution02()
        testPermutation01()
        testPermutation02()
        testCalculate01()
        testCalculate02()
    }

    fun testCalculate01() = test("Example 01") {
      val apartments = calculateApartment(3)
        apartments.shouldContainExactlyInAnyOrder(listOf(ApartmentType.SMALL, ApartmentType.SMALL, ApartmentType.SMALL), listOf(ApartmentType.SMALL, ApartmentType.LARGE), listOf(ApartmentType.LARGE, ApartmentType.SMALL))
    }

    fun testCalculate02() = test("Example 02") {
        val apartments = calculateApartment(4)
        apartments.shouldContainExactlyInAnyOrder(
            listOf(ApartmentType.SMALL, ApartmentType.SMALL, ApartmentType.SMALL, ApartmentType.SMALL),
            listOf(ApartmentType.SMALL, ApartmentType.SMALL, ApartmentType.LARGE),
            listOf(ApartmentType.SMALL, ApartmentType.LARGE, ApartmentType.SMALL),
            listOf(ApartmentType.LARGE, ApartmentType.SMALL, ApartmentType.SMALL),
            listOf(ApartmentType.LARGE, ApartmentType.LARGE)
        )
    }

    fun testCalculatePossibleSolution01() = test("Calculate possible solutions01") {
        val solution = calculatePossibleSolution(emptyList(), listOf(5, 2, 1), 16)
        solution shouldContain listOf(1, 5, 5, 5)
        solution shouldContain listOf(2, 2, 2, 5, 5)

        solution shouldNotContain listOf(3, 2, 2, 5, 5)
    }

    fun testCalculatePossibleSolution02() = test("Calculate possible solutions02") {
        val solution = calculatePossibleSolution(emptyList(), listOf(2, 1), 3)
        solution.shouldContainExactlyInAnyOrder( listOf(1, 1, 1), listOf(1, 2))
    }

    fun testPermutation01() = test("calculate all permutations01") {
        val permutation = permutations(listOf(1, 2))

        permutation.shouldContainExactlyInAnyOrder(listOf(1, 2), listOf(2, 1))
    }

    fun testPermutation02() = test("calculate all permutations02") {
        val permutation = permutations(listOf(1, 1, 1))

        permutation shouldBe  (setOf(listOf(1, 1, 1)))
    }
}