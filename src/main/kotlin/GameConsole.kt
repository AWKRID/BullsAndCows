package org.example

class GameConsole(private val level: Int = 3) {
    private var answer: String = ""

    fun run() {
        var userTry: String
        println("<게임을 시작합니다>")
        makeAnswer()
        while (true) {
            userTry = input("숫자를 입력하세요\n")
            if (!isValidInput(userTry)) {
                println("올바르지 않은 입력값입니다.")
                continue
            }
            if (checkAnswer(userTry)) break
        }
    }

    private fun makeAnswer() {
        val randomIntArray = makeRandomIntArray()
        answer = ""
        for (i in 0..<level) {
            answer += randomIntArray[i].toString()
        }
    }

    private fun makeRandomIntArray(): IntArray {
        val numberArray = IntArray(9) { it + 1 }
        repeat(level) {
            val firstNumber = numberArray.indices.random()
            val secondNumber = numberArray.indices.random()
            val temp = numberArray[firstNumber]
            numberArray[firstNumber] = numberArray[secondNumber]
            numberArray[secondNumber] = temp
        }
        return numberArray
    }

    private fun isValidInput(userInput: String): Boolean {
        if (userInput.length != level) return false
        if (userInput.toCharArray().distinct().size != level) return false
        if (userInput.contains("0")) return false
        for (char in userInput) if (!char.isDigit()) return false
        return true
    }

    private fun checkAnswer(userTry: String): Boolean {
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
}