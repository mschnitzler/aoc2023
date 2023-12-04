package com.github.mschnitzler.aoc2023.day01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FileParserTest {

    private val path1 = "src/test/resources/input1.txt"
    private val path2 = "src/test/resources/input2.txt"

    private val fileParser: FileParser = FileParser(LineParser(), ExtendLineParser())

    @Test
    fun processFile() {
        val result = fileParser.getCoordinatesFromFile(path1)
        assertEquals(142, result)
    }

    @Test
    fun processFileExtended() {
        val result = fileParser.getExtendedCoordinatesFromFile(path2)
        assertEquals(281, result)
    }
}