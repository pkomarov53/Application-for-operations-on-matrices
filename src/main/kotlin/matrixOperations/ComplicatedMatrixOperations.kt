package matrixOperations

import matrixOperations.ArithmeticMatrixOperations.Companion.multiplyMatrices

class ComplicatedMatrixOperations {
    companion object {
        fun determinant(matrix: Array<Array<Double>>): Double {
            require (matrix.size == matrix[0].size) {
                throw Exception("Матрица должна быть квадратной")
            }
            val n = matrix.size
            if (n == 2) {
                return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
            }
            var det = 0.0
            for (j in 0 until n) {
                val subMatrix = Array(n - 1) { Array(n - 1) { 0.0 } }
                for (i in 1 until n) {
                    for (k in 0 until n) {
                        if (k < j) {
                            subMatrix[i - 1][k] = matrix[i][k]
                        } else if (k > j) {
                            subMatrix[i - 1][k - 1] = matrix[i][k]
                        }
                    }
                }
                det += if (j % 2 == 0) matrix[0][j] * determinant(subMatrix)
                else -matrix[0][j] * determinant(subMatrix)
            }

            return det
        }

        fun inverseMatrix(matrix: Array<Array<Double>>): Array<Array<Double>> {
            val n = matrix.size
            if (n != matrix[0].size) {
                throw Exception("Матрица не может быть обратной")
            }
            val inv = Array(n) { Array(n) { 0.0 } }
            val aug = Array(n) { i ->
                Array(2 * n) { j ->
                    if (j < n) {
                        matrix[i][j]
                    } else {
                        if (i == j - n) 1.0 else 0.0
                    }
                }
            }
            for (i in 0 until n) {
                if (aug[i][i] == 0.0) {
                    var j = i + 1
                    while (j < n && aug[j][i] == 0.0) {
                        j++
                    }
                    if (j == n) {
                        throw Exception("Матрица не может быть обратной")
                    }
                    val temp = aug[i]
                    aug[i] = aug[j]
                    aug[j] = temp
                }
                val pivot = aug[i][i]
                for (j in 0 until 2 * n) {
                    aug[i][j] /= pivot
                }
                for (j in 0 until n) {
                    if (j != i) {
                        val factor = aug[j][i]
                        for (k in 0 until 2 * n) {
                            aug[j][k] -= factor * aug[i][k]
                        }
                    }
                }
            }

            for (i in 0 until n) {
                for (j in 0 until n) {
                    inv[i][j] = aug[i][j + n]
                }
            }
            return inv
        }

        fun checkInverseMatrix(matrix: Array<Array<Double>>, inverse: Array<Array<Double>>): Boolean {
            val product = multiplyMatrices(matrix, inverse)
            val identityMatrix = Array(matrix.size) { i ->
                Array(matrix[0].size) { j ->
                    if (i == j) 1.0 else 0.0
                }
            }
            for (i in product.indices) {
                for (j in product[0].indices) {
                    if (product[i][j] != identityMatrix[i][j]) {
                        return false
                    }
                }
            }
            return true
        }
    }
}
