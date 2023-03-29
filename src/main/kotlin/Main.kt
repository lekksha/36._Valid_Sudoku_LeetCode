class Solution {
    fun areRowsValid(board: Array<Array<Char>>): Boolean {
        var controlMatrix: Array<Char>
        for (i in 0..board.size - 1) {          //rows
            controlMatrix = Array(9) { index -> (index + 1 + 48).toChar() }
            outer@ for (j in 0..board[i].size - 1) {   //columns
                // ASCII : Char to Int
                when (board[i][j]) {
                    '.' -> continue@outer
                    in controlMatrix -> controlMatrix[(board[i][j]).toInt() - 48 - 1] = 0.toChar()
                    else -> return false
                }
            }
        }
        return true
    }


    fun areColumnsValid(board: Array<Array<Char>>): Boolean {
        var controlMatrix: Array<Char>
        for (i in 0..board[0].size - 1) {          //rows   //might have an exception if rows don't have same length
            controlMatrix = Array(9) { index -> (index + 1 + 48).toChar() }
            outer@ for (j in 0..board.size - 1) {   //columns
                when (board[j][i]) {
                    '.' -> continue@outer
                    in controlMatrix -> controlMatrix[(board[j][i]).toInt() - 48 - 1] = 0.toChar()
                    else -> return false
                }
            }
        }
        return true
    }

    fun isBoxValid(board: Array<Array<Char>>, rowIndexToStart: Int, colIndexToStart: Int): Boolean {
        var controlMatrix: Array<Char> = Array(9) { index -> (index + 1 + 48).toChar() }
        for (i in 0..2) {
            outer@ for (j in 0..2) {
                when (board[rowIndexToStart + i][colIndexToStart + j]) {
                    '.' -> continue@outer
                    in controlMatrix -> controlMatrix[(board[rowIndexToStart + i][colIndexToStart + j]).toInt() - 48 -1] = 0.toChar()
                    else -> return false
                }
            }
        }
        return true
    }

    fun areBoxesValid(board: Array<Array<Char>>): Boolean {
        for (i in 0..(board.size / 3) - 1) {
            for (j in 0..(board[i].size / 3) - 1) {
                if (isBoxValid(board, 3 * i, 3 * j))
                    continue
                else
                    return false
            }
        }
        return true
    }


    fun isValidSudoku(board: Array<Array<Char>>): Boolean {
        return areRowsValid(board) && areColumnsValid(board) && areBoxesValid(board)
    }
}




// Test example function below
fun main() {
    val board = arrayOf(
        arrayOf('5','3','.','.','7','.','.','.','.'),
        arrayOf('6','.','.','1','9','5','.','.','.'),
        arrayOf('.','9','8','.','.','.','.','6','.'),
        arrayOf('8','.','.','.','6','.','.','.','3'),
        arrayOf('4','.','.','8','.','3','.','.','1'),
        arrayOf('7','.','.','.','2','.','.','.','6'),
        arrayOf('.','6','.','.','.','.','2','8','.'),
        arrayOf('.','.','.','4','1','9','.','.','5'),
        arrayOf('.','.','.','.','8','.','.','7','9'),
    )
    val sol = Solution()
    println(sol.isValidSudoku(board))
}
