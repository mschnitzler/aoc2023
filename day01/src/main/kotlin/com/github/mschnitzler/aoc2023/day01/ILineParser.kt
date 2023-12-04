package com.github.mschnitzler.aoc2023.day01

fun interface ILineParser {

    fun getCoordinatesFromLine(line: String): Int
}
