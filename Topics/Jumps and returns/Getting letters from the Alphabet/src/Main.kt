fun main() {
    val input = readLine().toString()
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    var result = ""

    for (char in alphabet) {
        if (char.toString() == input) {
            break
        }
        result += char
    }
    println(result)
}