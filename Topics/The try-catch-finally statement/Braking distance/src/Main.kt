import kotlin.Exception

fun calculateBrakingDistance(v1: String, a: String): Int {
    val v2 = 0
    var breakingDistance = 0
    if (v1 == "" || a == "") {
        return -1
    }
    try {
        v1.toInt()
        a.toInt()
    } catch (e: Exception) {
        println(e.message)
        return -1
    }
    if (a.toInt() == 0) {
        try {
            1 / a.toInt()
        } catch (e: ArithmeticException) {
            println("The car does not slow down!")
            return -1
        }

    }
    return (v2 * v2 - v1.toInt() * v1.toInt()) / 2 * a.toInt()

}