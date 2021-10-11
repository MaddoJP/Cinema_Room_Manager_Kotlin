fun main() {
    val input = readLine()
    var counter = 0
    val occurrences = input?.filter { it in input }?.groupingBy { it }?.eachCount()
    if (occurrences != null) {
        for (i in occurrences) {
            if (i.value == 1) {
                counter++
            }
        }
    }
    println(counter)

}