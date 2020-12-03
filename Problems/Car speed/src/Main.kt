import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val speed = scanner.nextLine()!!.toInt()
    val limit = when (val limitValue = scanner.nextLine()) {
        "no limit" -> 60
        else -> limitValue.toInt()
    }
    println(when {
        limit < speed -> "Exceeds the limit by ${speed - limit} kilometers per hour"
        else -> "Within the limit"
    })
}
