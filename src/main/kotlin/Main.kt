package org.example

fun main() {
    val gameConsole = GameConsole()
    gameConsole.run()
}

fun input(message: String): String {
    print(message)
    return readln()
}
