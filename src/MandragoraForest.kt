fun mandragora(h: Array<Int>): Long {
    val n = h.size.toLong()

    val sortedH = h.sorted()

    var experience = sortedH[sortedH.size - 1].toLong() * n
    var health = sortedH[sortedH.size - 1].toLong()
    var index = sortedH.size - 2

    while (index >= 0) {
        health += sortedH[index].toLong()
        experience = maxOf(experience, health * (index +1).toLong())
        index--
    }

    return experience
}

fun main() {
    val t = readLine()!!.trim().toInt()

    (1..t).forEach { _ ->
        readLine()!!.trim().toInt()
        val h = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        val result = mandragora(h)

        println(result)
    }
}
