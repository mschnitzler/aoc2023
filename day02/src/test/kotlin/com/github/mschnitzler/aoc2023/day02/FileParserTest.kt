package com.github.mschnitzler.aoc2023.day02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FileParserTest {

    val input = "src/test/resources/input.txt"

    @Test
    fun sumOfGameIds() {
        val gameConfiguration = GameConfiguration(red = 12, green = 13, blue = 14)
        val fileParser = FileParser(LineParser())

        val result = fileParser.getSumOfIdsForValidGames(input, gameConfiguration)
        assertEquals(8, result)
    }

    @Test
    fun power() {
        val fileParser = FileParser(LineParser())

        val result = fileParser.getPower(input)
        assertEquals(2286, result)
    }
}