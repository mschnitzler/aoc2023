package com.github.mschnitzler.aoc2023.day02

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
class Day02(
    private val fileParser: FileParser
) : QuarkusApplication {

    private val input = "src/main/resources/input1.txt"

    override fun run(vararg args: String?): Int {
        part1()
        part2()
        return 0
    }

    fun part1() {
        val gameConfiguration = GameConfiguration(red = 12, green = 13, blue = 14)
        val result = fileParser.getSumOfIdsForValidGames(input, gameConfiguration)

        println("result for puzzle1: $result")
    }

    fun part2() {
        val result = fileParser.getPower(input)

        println("result for puzzle2: $result")
    }

}