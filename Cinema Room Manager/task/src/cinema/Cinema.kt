package cinema

import java.text.DecimalFormat
import java.util.*
import kotlin.system.exitProcess

const val SMALL_CINEMA_SIZE = 60
const val PRICE_FRONT_SEATS = 10
const val PRICE_BACK_SEATS = 8
const val EMPTY_SEAT = 'S'
const val BOOKED_SEAT = 'B'
val scan = Scanner(System.`in`)
var totalSeats = 0
var numberOfRows = 0
var numberOfColumns = 0
var seatsArray = Array(numberOfRows) { CharArray(numberOfColumns) }
var ticketsSold = 0
var ticketPrice = 0
var currentIncome = 0
var bookedRow = 0
var bookedSeat = 0
var maxIncome = 0
var input = ""


fun main() {


    fillSeats()
    calculateTotalIncome()
    menu()


}

fun calculateTotalIncome() {
    if (totalSeats <= SMALL_CINEMA_SIZE) {
        maxIncome = totalSeats * PRICE_FRONT_SEATS
    } else {
        val frontRows = numberOfRows / 2 * numberOfColumns
        val frontRowsIncome = frontRows * PRICE_FRONT_SEATS
        val backRows = totalSeats - frontRows
        val backRowsIncome = backRows * PRICE_BACK_SEATS
        maxIncome = frontRowsIncome + backRowsIncome
    }
}

fun fillSeats() {
    println("Enter the number of rows:")
    if (scan.hasNext()) {
        numberOfRows = scan.nextInt()
    }
    println("Enter the number of seats in each row:")
    if (scan.hasNext()) {
        numberOfColumns = scan.nextInt()
    }
    totalSeats = numberOfRows * numberOfColumns
    seatsArray = Array(numberOfRows) { CharArray(numberOfColumns) }

    for (i in 0..numberOfRows - 1) {
        for (j in 0..numberOfColumns - 1) {
            seatsArray[i][j] = EMPTY_SEAT
        }
    }

}

fun menu() {
    println(
        """
            
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
    """.trimIndent()
    )
    if (!scan.hasNext()) return
    input = scan.next().toString()

    when (input) {
        "1" -> drawCinema()
        "2" -> buyTicket()
        "3" -> showStatistics()
        "0" -> return
        else -> menu()
    }
}

fun buyTicket() {
    println("\nEnter a row number:")
    if (!scan.hasNext()) return
    bookedRow = scan.nextInt()

    println("Enter a seat number in that row:")
    if (!scan.hasNext()) return
    bookedSeat = scan.nextInt()


    if (bookedRow > numberOfRows || bookedSeat > numberOfColumns || bookedRow < 0 || bookedSeat < 0) {
        println("\nWrong input!")
        buyTicket()
    } else if (seatsArray[bookedRow - 1][bookedSeat - 1] == BOOKED_SEAT) {
        println("That ticket has already been purchased")
        buyTicket()
    } else {
        seatsArray[bookedRow - 1][bookedSeat - 1] = BOOKED_SEAT
        ticketsSold++
    }

    ticketPrice = calculatePrice(bookedRow)
    currentIncome += ticketPrice
    println("\nTicket price: $$ticketPrice")
    menu()

}

fun calculatePrice(row: Int): Int {
    if (totalSeats <= SMALL_CINEMA_SIZE) {
        return PRICE_FRONT_SEATS
    } else {
        if (row <= numberOfRows / 2) {
            return PRICE_FRONT_SEATS
        } else {
            return PRICE_BACK_SEATS
        }
    }
}

fun drawCinema() {
    println("\nCinema:")
    print("  ")
    for (i in 1..numberOfColumns) {
        print("$i ")
    }
    println()
    for (i in 1..numberOfRows) {
        print("$i ")
        for (j in 0..numberOfColumns - 1) {
            print("${seatsArray[i - 1][j]} ")
        }
        println()
    }
    menu()
}


fun showStatistics() {
    println("\nNumber of purchased tickets: $ticketsSold")
    var percentageSold = (ticketsSold * 1.00 / totalSeats * 100).toDouble()
    var result = String.format("%.2f", percentageSold)
    println("Percentage: $result%")
    println("Current income: $$currentIncome")
    println("Total income: $$maxIncome")
    menu()
}











