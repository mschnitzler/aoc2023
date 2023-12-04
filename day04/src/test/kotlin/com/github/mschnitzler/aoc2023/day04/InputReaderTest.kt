package com.github.mschnitzler.aoc2023.day04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InputReaderTest {

    @Test
    fun pilePoints() {
        val input = "src/test/resources/input.txt"
        val inputReader = InputReader(CardParser())
        val pile = inputReader.readPile(input)

        assertEquals(13, pile.points())
    }

    @Test
    fun winningPile() {
        val input = "src/test/resources/input.txt"
        val inputReader = InputReader(CardParser())
        val pile = inputReader.readPile(input)

        val total = pile.pileWithWinningCards()
            .map { it.value }
            .sum()

        assertEquals(30, total)
    }
}