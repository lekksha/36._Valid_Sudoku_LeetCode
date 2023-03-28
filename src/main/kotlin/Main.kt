class Solution {
    fun areRowsValid(board: Array<Array<Char?>>): Boolean {
        var controlMatrix: Array<Char?>
        for (i in 0..board.size - 1) {          //rows
            controlMatrix = Array(9) { index -> (index + 1).toChar() }
            for (j in 0..board[i].size - 1) {   //columns
                // ASCII : Char to Int
                when (board[i][j]) {
                    '.' -> continue
                    in controlMatrix -> controlMatrix[(board[i][j])!!.code - 48 + 1] = null //ASCII : Char to Int    //!! assertion operator
                    else -> return false
                }
            }
        }
        return true
    }


    fun areColumnsValid(board: Array<Array<Char?>>): Boolean {
        var controlMatrix: Array<Char?>
        for (i in 0..board[0].size - 1) {          //rows   //might have an exception if rows don't have same length
            controlMatrix = Array(9) { index -> (index + 1).toChar() }
            for (j in 0..board.size - 1) {   //columns
                when (board[j][i]) {
                    '.' -> continue
                    in controlMatrix -> controlMatrix[(board[i][j])!!.code - 48 + 1] = null //ASCII : Char to Int    //!! assertion operator
                    else -> return false
                }
            }
        }
        return true
    }

    fun isBoxValid(board: Array<Array<Char?>>, rowIndexToStart: Int, colIndexToStart: Int): Boolean {
        var controlMatrix: Array<Char?> = Array(9) { index -> (index + 1).toChar() }
        for (i in 0..2) {
            for (j in 0..2) {
                when (board[rowIndexToStart + i][colIndexToStart + j]) {
                    '.' -> continue
                    in controlMatrix -> controlMatrix[(board[rowIndexToStart + i][colIndexToStart + j])!!.code - 48 + 1] =
                        null

                    else -> return false
                }
            }
        }
        return true
    }

    fun areBoxesValid(board: Array<Array<Char?>>): Boolean {
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


    fun isValidSudoku(board: Array<Array<Char?>>): Boolean {
        return areRowsValid(board) && areColumnsValid(board) && areBoxesValid(board)
    }
}

//fun main(args: Array<String>) {
//
//}

