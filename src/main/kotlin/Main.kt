package org.example

var answer = "456"
const val level = 3
fun main() {


    var userTry: String
    println("<게임을 시작합니다>")
    makeAnswer(level)
    println(answer)
    while (true) {
        userTry = input("숫자를 입력하세요\n")
        if(!isValidInput(userTry)){
            println("올바르지 않은 입력값입니다.")
            continue
        }
        if (checkAnswer(userTry)) break
    }

}

fun isValidInput(userInput: String): Boolean {
    if (userInput.length != level) return false
    if (userInput.toCharArray().distinct().size != level) return false
    if(userInput.contains("0")) return false
    return true
}

fun checkAnswer(userTry: String): Boolean {
    if (userTry == answer) {
        println("정답입니다!")
        return true
    }

    var ballCount = 0
    var strikeCount = 0
    for (userIdx in userTry.indices) {
        for (answerIdx in answer.indices) {
            if (userTry[userIdx] == answer[answerIdx]) {
                if (userIdx == answerIdx) strikeCount++
                else ballCount++
            }
        }
    }
    if (ballCount == 0 && strikeCount == 0) println("Out!")
    else if (ballCount == 0) println("${strikeCount}S")
    else if (strikeCount == 0) println("${ballCount}B")
    else println("${strikeCount}S${ballCount}B")
    return false
}

fun input(message: String): String {
    print(message)
    return readln()
}

fun makeAnswer(size: Int) {
    val numberArray = IntArray(9) { it + 1 }
    repeat(size) {
        val firstNumber = numberArray.indices.random()
        val secondNumber = numberArray.indices.random()
        val temp = numberArray[firstNumber]
        numberArray[firstNumber] = numberArray[secondNumber]
        numberArray[secondNumber] = temp
    }
    answer = ""
    for (i in 0..<size) {
        answer += numberArray[i].toString()
    }
}