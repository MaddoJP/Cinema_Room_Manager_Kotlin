const val GRAVITY = 9.8

fun main() {
    val density = readLine()!!.toDouble()
    val heightColumn = readLine()!!.toDouble()
    val result = density * heightColumn * GRAVITY
    println(result)
}