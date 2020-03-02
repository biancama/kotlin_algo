fun calculateApartment(num: Int) :  List<List<ApartmentType>> {
    val solutions = calculatePossibleSolution(emptyList(), listOf(2, 1), num)

    val solutionAsInteger = solutions.flatMap { x -> permutations(x) }
    return solutionAsInteger.map { y -> y.map { x ->  if (x == 1) ApartmentType.SMALL else ApartmentType.LARGE}  }
}

fun calculatePossibleSolution(result: List<Int>, possibilities: List<Int>,  num: Int): Set<List<Int>> {
    if (num == 0) {
        return setOf(result)
    } else {
       if (num < 0 || possibilities == emptyList<ApartmentType>()) {
           return emptySet()
       } else {
           return calculatePossibleSolution(listOf(possibilities.get(0)) + result, possibilities, num - possibilities.get(0)).union(calculatePossibleSolution(result, possibilities.drop(1), num ))
       }
    }
}

//fun permutations(inputList: List<Int>): List<List<Int>> {
//    if (inputList.size < 2) {
//        return listOf(inputList)
//    } else {
//        return inputList.flatMap { x -> permutations(inputList.minus(x)) .map { y -> y.plus(x).toList() } }
//    }
//}

fun permutations(inputList: List<Int>): Set<List<Int>> {
    if (inputList.size < 2) {
        return setOf(inputList)
    } else {
        return inputList.flatMap { x ->
            permutations(inputList.minus(x)).map { y -> y.plus(x) }
        }.toSet()
    }
}
