package com.github.mschnitzler.aoc2023.day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ExtendLineParserTest {

    private val parser: ExtendLineParser = ExtendLineParser()

    @ParameterizedTest
    @CsvSource(
        "two1nine,29",
        "eightwothree,83",
        "abcone2threexyz,13",
        "xtwone3four,24",
        "4nineeightseven2,42",
        "zoneight234,14",
        "7pqrstsixteen,76"
    )
    fun parseLine(input: String, expected: Int) {
        val result = parser.getCoordinatesFromLine(input)
        assertEquals(expected, result)
    }
}


