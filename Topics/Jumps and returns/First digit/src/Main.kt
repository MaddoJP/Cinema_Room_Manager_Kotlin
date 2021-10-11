fun main() {
    val input = readLine().toString()
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    for (c in input) {
        if (c !in alphabet) {
            println(c)
            break
        }
    }
}