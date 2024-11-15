fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {

    val array = LongArray(n + 1) { 0L }

    for (query in queries) {
        val a = query[0] - 1
        val b = query[1]
        val k = query[2].toLong()

        array[a] += k
        if (b < n) array[b] -= k

    }

    var max = 0L
    var sum = 0L
    for (value in array) {
        sum += value
        if (sum > max) max = sum
    }

    return max
}

fun main() {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")

    val n = firstMultipleInput[0].toInt()
    val m = firstMultipleInput[1].toInt()

    val queries = Array<Array<Int>>(m) { Array<Int>(3) { 0 } }

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    print(result)
}