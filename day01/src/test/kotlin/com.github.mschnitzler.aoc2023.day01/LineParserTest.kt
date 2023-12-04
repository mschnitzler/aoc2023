package com.github.mschnitzler.aoc2023.day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LineParserTest {

    private val lineParser: LineParser = LineParser()

    @Test
    fun multipleDigits() {
        val input = "ar34dg5k6l"
        val result = lineParser.getCoordinatesFromLine(input)
        assertEquals(36, result)
    }

    @Test
    fun singleDigit() {
        val input = "abc2def"
        val result = lineParser.getCoordinatesFromLine(input)
        assertEquals(22, result)
    }

    @Test
    fun noDigit() {
        val input = "abcdef"
        val result = lineParser.getCoordinatesFromLine(input)
        assertEquals(0, result)
    }
}