package org.example

const val secretNumber = "456"
fun main() {


    var userTry: String
    println("<게임을 시작합니다>")

    while (true) {
        userTry = input("숫자를 입력하세요\n")
        if (checkAnswer(userTry)) break
    }

}

fun checkAnswer(userTry: String): Boolean {
    if (userTry == secretNumber) {
        println("정답입니다!")
        return true
    }

    var ballCount = 0
    var strikeCount = 0
    for (userIdx in userTry.indices) {
        for (answerIdx in secretNumber.indices) {
            if (userTry[userIdx] == secretNumber[answerIdx]) {
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