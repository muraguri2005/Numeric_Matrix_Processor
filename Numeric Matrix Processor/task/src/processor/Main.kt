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
        println()
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
    println("Enter the size of the first matrix: ")
    val m1 = getMatrix(scanner, "first")
    println("Enter the size of the second matrix: ")
    val m2 = getMatrix(scanner, "second")
    if (m1.size != m2.size || m1[0].size != m2[0].size) {
        println("The operation cannot be performed.")
    } else {
        println("The result is:")
        for (i in m1.indices) {
            for (j in m1[0].indices) {
                print("${(m1[i][j] + m2[i][j])} ")
            }
            println()
        }
    }
}


fun multiplyMatrixByConstant(scanner: Scanner) {
    println("Enter the size of matrix: ")
    val m1 = getMatrix(scanner)
    println("Enter constant: ")
    val constant = scanner.nextLine().toDouble()
    println("The result is:")
    for (i in m1.indices) {
        for (j in m1[0].indices) {
            print("${(m1[i][j] * constant)} ")
        }
        println()
    }
}

fun multiplyMatrices(scanner: Scanner) {
    println("Enter the size of the first matrix: ")
    val m1 = getMatrix(scanner, "first")
    println("Enter the size of the second matrix: ")
    val m2 = getMatrix(scanner, "second")
    if (m1[0].size != m2.size) {
        println("The operation cannot be performed.")
    } else {
        for (i in m1.indices) {
            for (j in m2[0].indices) {

                var cij = 0.0
                for (k in m2.indices) {
//                    println("${m1[i][k]} X ${m2[k][j]}")
                    cij += (m1[i][k] * m2[k][j])
                }
                print("$cij ")
            }
            println()
        }
    }
}

fun getMatrix(scanner: Scanner, matrix: String = ""): Array<List<Double>> {
    val mRC = scanner.nextLine().split(" ")
    println("Enter $matrix matrix:")
    return Array(mRC[0].toInt()) {
        scanner.nextLine().trim().split(" ").map { it.toDouble() }
    }
}
