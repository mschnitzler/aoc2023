package com.github.mschnitzler.aoc2023.day02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LineParserTest {

    val lineParser = LineParser()

    @Test
    fun parseGameId() {
        val line = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
        val match = lineParser.regexGame.find(line)!!
        val result = lineParser.extractGameId(match)
        assertEquals(2, result)
    }

    @Test
    fun parseDraw() {
        val line = "1 blue, 2 green, 3 red"
        val result = lineParser.parseDraw(line)

        assertEquals(1, result.blue)
        assertEquals(2, result.green)
        assertEquals(3, result.red)
    }

    @Test
    fun parseDrawSet() {
        val line = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
        val match = lineParser.regexGame.find(line)!!
        val result = lineParser.extractGameSets(match)

        val expected = listOf(
            Draw(blue = 1, green = 2, red = 0),
            Draw(blue = 4, green = 3, red = 1),
            Draw(blue = 1, green = 1, red = 0)
        )

        assertContentEquals(expected, result)
    }
}