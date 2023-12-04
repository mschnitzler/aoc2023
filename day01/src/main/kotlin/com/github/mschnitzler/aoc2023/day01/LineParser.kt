package com.github.mschnitzler.aoc2023.day01

import jakarta.enterprise.context.ApplicationScoped
import kotlin.streams.toList

@ApplicationScoped
class LineParser : ILineParser {
    val lower = '0'.code
    val upper = '9'.code

    override fun getCoordinatesFromLine(line: String): Int {
        val list = line.chars()
            .filter { it >= lower && it <= upper }
            .map { it - lower }
            .toList()

        return if (list.isEmpty()) 0 else list[0] * 10 + list[list.size-1]
    }
}