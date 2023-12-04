package com.github.mschnitzler.aoc2023.day04

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CardParser {

    val regex = """Card\s+(?<id>\d+):(?<winning>(\s+\d+)+) \|(?<picked>(\s+\d+)+)""".toRegex()

    fun readCard(line: String): Card {
        val match = regex.find(line)!!

        val id = match.groups["id"]!!.value.toInt()

        val winningLine = match.groups["winning"]!!.value
        val winningNumbers = extractNumbersFromString(winningLine)

        val pickedLine = match.groups["picked"]!!.value
        val pickedNumbers = extractNumbersFromString(pickedLine)

        return Card(id = id, winningNumbers = winningNumbers, pickedNumbers = pickedNumbers)
    }

    fun extractNumbersFromString(line: String): List<Int> {
        return line.split(" ")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }
}