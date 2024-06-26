package org.example

class GameConsole() {
    private var level: Int = 3
    private var answer: String = ""
    private var gameRecord: MutableList<Pair<Int,Int>> = mutableListOf()
    fun run() {
        while (true) {
            printMenu()
            val userChoice = readln()
            when (userChoice) {
                "1" -> startGame()
                "2" -> showRecord()
                "3" -> changeLevel()
                "4" -> {
                    println("<숫자 야구 게임을 종료합니다>")
                    return
                }

                else -> println("올바른 숫자를 입력해주세요!")
            }
        }
    }


    private fun printMenu() {
        printDashedLine()
        println("환영합니다! 원하시는 번호를 입력해주세요.")
        println("현재 난이도: Lv.${level-2}")
        println("1. 게임 시작하기\n2. 게임 기록 보기\n3. 난이도 변경하기\n4. 종료하기")
        printDashedLine()
    }

    private fun changeLevel() {
        println("<난이도 변경하기>")
        for (i in 1..4) println("${i}. ${i + 2}자리 숫자")
        println("메인메뉴로 돌아가려면 이외의 키를 입력해주세요.")
        printDashedLine()
        when (val levelInput = readln()) {
            in "1", "2", "3", "4" -> {
                level = levelInput.toInt() + 2
                println("현재 난이도가 [${level}자리 숫자]로 변경됩니다. ")
            }
            else -> return
        }
    }

    private fun startGame() {
        var userTry: String
        var count = 0
        println("<게임을 시작합니다>")
        makeAnswer()

        while (true) {
            userTry = input("숫자를 입력하세요\n")
            if (!isValidInput(userTry)) {
                println("올바르지 않은 입력값입니다.")
                continue
            }
            count++
            if (checkAnswer(userTry)) break
        }
        gameRecord.add(Pair(level,count))

    }

    private fun showRecord() {
        println("<게임 기록 보기>")
        printDashedLine()
        if (gameRecord.isEmpty()) println("아직 게임 기록이 없습니다.")
        gameRecord.forEachIndexed { index, it -> println("${index + 1}번째 게임(Lv.${it.first-2}) : 시도 횟수 - ${it.second}") }
    }

    private fun makeAnswer() {
        val randomIntArray = makeRandomIntArray()
        answer = ""
        for (i in 0..<level) {
            answer += randomIntArray[i].toString()
        }
    }

    private fun isValidInput(userInput: String): Boolean {
        if (userInput.length != level) return false
        if (userInput.toCharArray().distinct().size != level) return false
        if (userInput[0] == '0') return false
        for (char in userInput) if (!char.isDigit()) return false
        return true
    }

    private fun checkAnswer(userTry: String): Boolean {
        if (userTry == answer) {
            println("정답입니다!")
            return true
        }
        val counts: Pair<Int, Int> = checkCounts(userTry)
        showCounts(counts.first, counts.second)
        printDashedLine()
        return false
    }

    private fun checkCounts(userTry: String): Pair<Int, Int> {
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
        return Pair(ballCount, strikeCount)
    }

    private fun showCounts(ballCount: Int, strikeCount: Int) {
        if (ballCount == 0 && strikeCount == 0) println("Out!")
        else if (ballCount == 0) println("${strikeCount}S")
        else if (strikeCount == 0) println("${ballCount}B")
        else println("${strikeCount}S${ballCount}B")
    }
}