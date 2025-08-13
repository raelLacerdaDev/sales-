fun main() {
    val result = totalSales(
        listOf(
            "8349,14/09/2024,899.9,ESPORTE",
            "4837,17/09/2024,530.0,VESTUARIO",
            "15281,21/09/2024,1253.99,ESPORTE",
            "15344,27/09/2024,1000.9,VESTUARIO",
            "18317,04/10/2024,250.4,VESTUARIO",
            "18972,11/10/2024,385.5,JARDINAGEM"
        ),
        department = "VESTUARIO"
    )
    val numberFormat = String.format("%.2f", result[1])
    println("${result[0].toInt()} VENDAS")
    println("TOTAL = $ $numberFormat")
}


fun totalSales (sales: List<String>, department: String): Array<Double> {
    val pair = totalSalesTR(sales,department)
    val result =  arrayOf(pair.first.toDouble(),pair.second)
    return result
}

tailrec fun totalSalesTR(sales: List<String>, department: String, amount: Double = 0.0, count: Int = 0) : Pair<Int, Double> {
    if (sales.isEmpty()) return Pair(count, amount)
    val parsed = sales.first().split(",")
    val tail = sales.drop(1)
    return if (parsed[3] == department) {
        totalSalesTR(tail, department, amount + parsed[2].toDouble(), count + 1)
    } else {
        totalSalesTR(tail, department, amount,count)
    }
}
