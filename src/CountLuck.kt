import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

fun countLuck(matrix: Array<String>, k: Int): String {
    val n = matrix.size
    val m = matrix[0].length
    val directions = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

    var startX = 0
    var startY = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (matrix[i][j] == 'M') {
                startX = i
                startY = j
            }
        }
    }

    val visited = Array(n) { BooleanArray(m) { false } }
    val stack = Stack<Triple<Int, Int, Int>>()
    stack.push(Triple(startX, startY, 0))

    while (stack.isNotEmpty()) {
        val (x, y, decisions) = stack.pop()

        if (matrix[x][y] == '*') return if (decisions == k) "Impressed" else "Oops!"
        visited[x][y] = true

        var possibleMoves = 0
        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy
            if (nx in 0 until n && ny in 0 until m && matrix[nx][ny] != 'X' && !visited[nx][ny]) {
                possibleMoves++
            }
        }

        val newDecisions = if (possibleMoves > 1) decisions + 1 else decisions

        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy

            if (nx in 0 until n && ny in 0 until m && matrix[nx][ny] != 'X' && !visited[nx][ny]) {
                stack.push(Triple(nx, ny, newDecisions))
            }
        }
    }
    return "Oops!"
}

fun main() {
    val t = readLine()!!.trim().toInt()

    (1..t).forEach { tItr ->
        val firstMultipleInput = readLine()!!.trimEnd().split(" ")

        val n = firstMultipleInput[0].toInt()

        firstMultipleInput[1].toInt()

        val matrix = Array<String>(n) { "" }
        for (i in 0 until n) {
            val matrixItem = readLine()!!
            matrix[i] = matrixItem
        }

        val k = readLine()!!.trim().toInt()

        val result = countLuck(matrix, k)

        println(result)
    }
}