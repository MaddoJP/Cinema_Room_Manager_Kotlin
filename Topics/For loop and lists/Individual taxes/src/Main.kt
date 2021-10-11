fun main() {
    val numberOfCompanies = readLine()!!.toInt()
    val mutList: MutableList<Int> = mutableListOf()
    for (i in 1..numberOfCompanies) {
        mutList.add(readLine()!!.toInt())
    }

    val taxRate: MutableList<Double> = mutableListOf()
    for (i in 1..numberOfCompanies) {
        taxRate.add(readLine()!!.toDouble() / 100)
    }

    val taxesPerCompany: MutableList<Double> = mutableListOf()

    for (i in 0 until taxRate.size) {
        val taxes = taxRate[i] * mutList[i]
        taxesPerCompany.add(taxes)
    }

    for (d in taxesPerCompany) {
        if (d == taxesPerCompany.maxOrNull()) {
            println(taxesPerCompany.indexOf(d) + 1)
        }
    }
}