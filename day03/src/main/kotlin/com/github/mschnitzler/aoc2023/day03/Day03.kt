package com.github.mschnitzler.aoc2023.day03

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
class Day03(private val parser: EngineSchematicParser) : QuarkusApplication {

    override fun run(vararg args: String?): Int {
        val path = "src/main/resources/input.txt"
        val engineSchematic = parser.parseFile(path)

        part1(engineSchematic)
        part2(engineSchematic)
        return 0
    }

    private fun part1(engineSchematic: EngineSchematic) {
        val parts = engineSchematic.adjacentParts()
        val result = parts.map { it.number }.sum()

        println("result part 1: $result")
    }

    private fun part2(engineSchematic: EngineSchematic) {
        val gears = engineSchematic.gears()
        val result = gears.map { it.ratio() }.sum()

        println("result part 2: $result")
    }

}