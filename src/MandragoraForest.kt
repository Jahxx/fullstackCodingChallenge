fun main() {
    val t = readLine()!!.trim().toInt()

    (1..t).forEach { _ ->
        readLine()!!.trim().toInt()
        val h = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        val result = mandrake(h)
        
        println(result)
    }
}

fun mandrake(h: Array<Int>): Long {
    return 0
}
