package com.github.mschnitzler.aoc2023.day04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CardParserTest {

    @Test
    fun parseCard() {
        val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val parser = CardParser()
        val result = parser.readCard(input)

        assertEquals(1, result.id)
        assertEquals(5, result.winningNumbers.size)
        assertEquals(8, result.pickedNumbers.size)
    }

    @Test
    fun points() {
        val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val parser = CardParser()
        val result = parser.readCard(input)

        assertEquals(8, result.points())
    }
}