package processor

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var choice: Int
    do {
        printMenu()
        choice = scanner.nextLine().toInt()
        when (choice) {
            1 -> {
                addMatrices(scanner)
            }
            2 -> {
                multiplyMatrixByConstant(scanner)
            }
            3 -> {
                multiplyMatrices(scanner)
            }
        }
    } while (choice != 0)
}

fun printMenu() {
    println("1. Add matrices")
    println("2. Multiply matrix by a constant")
    println("3. Multiply matrices")
    println("0. Exit")
    print("Your choice: ")
}

fun addMatrices(scanner: Scanner) {
    val m1 = getMatrix(scanner)
    val m2 = getMatrix(scanner)
    if (m1.size != m2.size || m1[0].size != m2[0].size) {
        println("ERROR")
    } else {
        for (i in m1.indices) {
            for (j in m1[0].indices) {
                print("${(m1[i][j] + m2[i][j])} ")
            }
            println()
        }
    }
}


fun multiplyMatrixByConstant(scanner: Scanner) {
    val m1 = getMatrix(scanner)
    val constant = scanner.nextLine().toDouble()
    for (i in m1.indices) {
        for (j in m1[0].indices) {
            print("${(m1[i][j] * constant)} ")
        }
        println()
    }
}

//do actual multiplication
fun multiplyMatrices(scanner: Scanner) {
    val m1 = getMatrix(scanner)
    val m2 = getMatrix(scanner)
    if (m1.size != m2.size || m1[0].size != m2[0].size) {
        println("ERROR")
    } else {
        for (i in m1.indices) {
            for (j in m1[0].indices) {
                print("${(m1[i][j] + m2[i][j])} ")
            }
            println()
        }
    }
}

fun getMatrix(scanner: Scanner): Array<List<Double>> {
    val mRC = scanner.nextLine().split(" ")
    return Array(mRC[0].toInt()) {
        scanner.nextLine().trim().split(" ").map { it.toDouble() }
    }
}
