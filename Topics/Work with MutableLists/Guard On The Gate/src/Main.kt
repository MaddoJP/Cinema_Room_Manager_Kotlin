fun main() {
    val backFromTheWall = readLine()!!.split(", ").map { it }.toMutableList()
    val returnedWatchman = readLine()!!.toString()  
    // do not touch the lines above
    // write your code here   
    val allReturners = backFromTheWall + returnedWatchman
    println(allReturners.joinToString())
}