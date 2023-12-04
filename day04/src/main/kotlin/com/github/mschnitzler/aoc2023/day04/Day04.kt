package com.github.mschnitzler.aoc2023.day04

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
class Day04(val inputReader: InputReader) : QuarkusApplication {

    val input = "src/main/resources/input.txt"

    override fun run(vararg args: String?): Int {
        part1()
        part2()
        return 0
    }

    fun part1() {
        val pile = inputReader.readPile(input)
        println("result for part 1: ${pile.points()}")
    }

    fun part2() {
        val pile = inputReader.readPile(input)
        val total = pile.pileWithWinningCards()
            .map { it.value }
            .sum()
        println("result for part 2: $total")
    }
}