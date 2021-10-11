fun main() {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    val input = readLine().toString()
    var output = ""
    for (char in alphabet) {
        if(char !in input) {
            output += char
        }
    }
    println(output)
}