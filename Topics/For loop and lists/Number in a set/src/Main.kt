fun main() {
    var counter = 0
    val size = readLine()!!.toInt()
    val mutList: MutableList<Int> = mutableListOf()
    for (i in 1..size) {
        mutList.add(readLine()!!.toInt())
    }
    val target = readLine()!!.toInt()

    if (target in mutList) {
        println("YES")
    } else {
        println("NO")
    }
}