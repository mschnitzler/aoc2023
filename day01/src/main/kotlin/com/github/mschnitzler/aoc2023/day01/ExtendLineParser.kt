package com.github.mschnitzler.aoc2023.day01

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ExtendLineParser : ILineParser {

    override fun getCoordinatesFromLine(line: String): Int {
        val list = extractNumbers(line)
        return if (list.isEmpty()) 0 else list[0] * 10 + list[list.size - 1]
    }

    private fun extractNumbers(line: String): List<Int> {
        return (0..line.length - 1)
            .map { mapStartAsNumber(line, it) }
            .filter { it > 0 }
            .toList()
    }

    private fun mapStartAsNumber(original: String, index: Int): Int {
        val line = original.substring(index)
        return when {
            line[0].isDigit() -> line[0].digitToInt()
            line.startsWith("one") -> 1
            line.startsWith("two") -> 2
            line.startsWith("three") -> 3
            line.startsWith("four") -> 4
            line.startsWith("five") -> 5
            line.startsWith("six") -> 6
            line.startsWith("seven") -> 7
            line.startsWith("eight") -> 8
            line.startsWith("nine") -> 9
            else -> 0
        }
    }
}