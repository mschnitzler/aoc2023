package com.github.mschnitzler.aoc2023.day03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContains

class EngineSchematicParserTest {


    @Test
    fun testProcessParts() {
        val indexedLine = IndexedValue(value = "467..114..", index = 2)

        val parser = EngineSchematicParser()
        parser.processLine(indexedLine)

        assertContains(parser.parts, Part(467, 0, 2))
        assertContains(parser.parts, Part(114, 5, 2))
    }

    @Test
    fun testProcessSymbols() {
        val indexedLine = IndexedValue(value = "...#.*....", index = 9)

        val parser = EngineSchematicParser()
        parser.processLine(indexedLine)

        assertContains(parser.symbols, Symbol("#", 3, 9))
        assertContains(parser.symbols, Symbol("*", 5, 9))
    }

    @Test
    fun testProcessPartsAndSymbols() {
        val indexedLine = IndexedValue(value = "617*......", index = 99)

        val parser = EngineSchematicParser()
        parser.processLine(indexedLine)

        assertContains(parser.parts, Part(617, 0, 99))
        assertContains(parser.symbols, Symbol("*", 3, 99))
    }

    @Test
    fun sumpOfAdjacentParts() {
        val parser = EngineSchematicParser()
        val engineSchematic = parser.parseFile("src/test/resources/input.txt")

        val sum = engineSchematic.adjacentParts()
            .map { it.number }
            .sum()

        assertEquals(4361, sum)
    }

    @Test
    fun sumOfGearRatios() {
        val parser = EngineSchematicParser()
        val engineSchematic = parser.parseFile("src/test/resources/input.txt")

        val sum = engineSchematic.gears()
            .map { it.ratio() }
            .sum()

        assertEquals(467835, sum)
    }
}