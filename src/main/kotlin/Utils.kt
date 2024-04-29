package org.example

fun swap(array: IntArray, index1: Int, index2: Int) {
    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}

fun printDashedLine() {
    println("--------------------------------------")
}

fun input(message: String): String {
    print(message)
    return readln()
}

fun makeRandomIntArray(): IntArray {
    val numberArray = IntArray(10) { it }
    repeat(30) {
        val index1 = numberArray.indices.random()
        val index2 = numberArray.indices.random()
        swap(numberArray, index1, index2)
    }
    if (numberArray[0] == 0) swap(numberArray, 0, numberArray.lastIndex)
    return numberArray
}