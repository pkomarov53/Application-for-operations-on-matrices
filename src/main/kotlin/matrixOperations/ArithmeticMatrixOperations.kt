package matrixOperations

class ArithmeticMatrixOperations {
    companion object {
        fun addMatrices(matrix1: Array<Array<Double>>, matrix2: Array<Array<Double>>): Array<Array<Double>> {
            require (matrix1.size == matrix2.size && matrix1[0].size == matrix2[0].size) {
                throw Exception("Размерность матриц должна быть одинаковой")
            }
            val result = Array(matrix1.size) { Array(matrix1[0].size) { 0.0 } }
            for (i in matrix1.indices) {
                for (j in matrix1[0].indices) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j]
                }
            }
            return result
        }

        fun subtractMatrices(matrix1: Array<Array<Double>>, matrix2: Array<Array<Double>>): Array<Array<Double>> {
            require (matrix1.size == matrix2.size && matrix1[0].size == matrix2[0].size) {
                throw Exception("Размерность матриц должна быть одинаковой")
            }
            val result = Array(matrix1.size) { Array(matrix1[0].size) { 0.0 } }
            for (i in matrix1.indices) {
                for (j in matrix1[0].indices) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j]
                }
            }
            return result
        }

        fun multiplyMatrixByScalar(matrix: Array<Array<Double>>, scalar: Double): Array<Array<Double>> {
            val result = Array(matrix.size) { Array(matrix[0].size) { 0.0 } }
            for (i in matrix.indices) {
                for (j in matrix[0].indices) {
                    result[i][j] = matrix[i][j] * scalar
                }
            }
            return result
        }

        fun multiplyMatrices(matrix1: Array<Array<Double>>, matrix2: Array<Array<Double>>): Array<Array<Double>> {
            val result = Array(matrix1.size) { Array(matrix2[0].size) { 0.0 } }
            for (i in matrix1.indices) {
                for (j in matrix2[0].indices) {
                    for (k in matrix2.indices) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j]
                    }
                }
            }
            return result
        }

        fun powerMatrix(matrix: Array<Array<Double>>, power: Int): Array<Array<Double>> {
            var result = matrix
            for (i in 1 until power) {
                result = multiplyMatrices(result, matrix)
            }
            return result
        }
    }
}
