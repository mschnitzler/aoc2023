package com.github.mschnitzler.aoc2023.day01

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
class Day01(
    private val fileParser: FileParser,
) : QuarkusApplication {

    val input = "src/main/resources/input.txt"

    override fun run(vararg args: String?): Int {
        part1()
        part2()
        return 0
    }

    private fun part1() {
        val result1 = fileParser.getCoordinatesFromFile(input)
        println("result for part 1: $result1")
    }

    private fun part2() {
        val result2 = fileParser.getExtendedCoordinatesFromFile(input)
        println("result for part 2: $result2")
    }
}