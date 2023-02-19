import matrixOperations.ArithmeticMatrixOperations
import matrixOperations.ComplicatedMatrixOperations
import kotlin.math.roundToInt
import kotlin.random.Random

fun printMatrix(matrix: Array<Array<Double>>) {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} ")
        }
        println()
    }
    println()
}

fun main() {
    val firstMatrix = arrayOf(
        arrayOf(Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble()),
        arrayOf(Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble()),
        arrayOf(Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble())
    )

    val secondMatrix = arrayOf(
        arrayOf(Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble()),
        arrayOf(Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble()),
        arrayOf(Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble(),
            Random.nextDouble(1.0, 10.0).roundToInt().toDouble())
    )

    println("\nМатрица №1: ")
        printMatrix(firstMatrix)

    println("Матрица №2: ")
        printMatrix(secondMatrix)

    println("Сумма матриц:")
    for (row in ArithmeticMatrixOperations.addMatrices(firstMatrix, secondMatrix)) {
        println(row.joinToString(" "))
    }

    println("\nРазность матриц:")
    for (row in ArithmeticMatrixOperations.subtractMatrices(firstMatrix, secondMatrix)) {
        println(row.joinToString(" "))
    }

    print("\nУмножение матрицы на число ->  ")
    for (row in ArithmeticMatrixOperations.multiplyMatrixByScalar(firstMatrix, readln().toDouble())) {
        println(row.joinToString(" "))
    }

    println("\nУмножение матриц: ")
    for (row in ArithmeticMatrixOperations.multiplyMatrices(firstMatrix, secondMatrix)) {
        println(row.joinToString(" "))
    }

    print("\nВозведение матрицы в степень -> ")
    for (row in ArithmeticMatrixOperations.powerMatrix(firstMatrix, readln().toInt())) {
        println(row.joinToString(" "))
    }

    println("\nНахождение определителя матрицы: ${ComplicatedMatrixOperations.determinant(firstMatrix)}")

    println("\nНахождение обратной матрицы:")
    for (row in ComplicatedMatrixOperations.inverseMatrix(firstMatrix)) {
        println(row.joinToString(" "))
    }

    print("\nПроверка на правильность обратной матрицы -> " +
           "${ComplicatedMatrixOperations.checkInverseMatrix(firstMatrix, 
               ComplicatedMatrixOperations.inverseMatrix(firstMatrix))}\n")
}
