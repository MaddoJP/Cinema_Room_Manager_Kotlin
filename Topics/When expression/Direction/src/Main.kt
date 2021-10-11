fun main() {
    val input = readLine().toString()

    when (input) {
        "1", "up" -> println("move up")
        "2", "down" -> println("move down")
        "3", "left" -> println("move left")
        "4", "right" -> println("move right")
        "0", "stay" -> println("do not move")
        else -> println("error!")
    }
}