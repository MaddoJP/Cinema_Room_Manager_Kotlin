fun main() {
    val var1 = readLine().toString()
    val op = readLine().toString()
    val var2 = readLine().toString()

    when (op) {
        "equals" -> println((var1 == var2).toString())
        "plus" -> println(var1 + var2)
        "endsWith" -> print((var1.endsWith(var2)).toString())
        else -> println("Unknown operation")
    }
}