package com.github.mschnitzler.aoc2023.day01

import jakarta.enterprise.context.ApplicationScoped
import java.io.File

@ApplicationScoped
class FileParser(
    private val lineParser: LineParser,
    private val extendLineParser: ExtendLineParser
) {

    fun getCoordinatesFromFile(path: String): Int {
        return getCoordinatesWithParser(path, lineParser)
    }

    fun getExtendedCoordinatesFromFile(path: String): Int {
        return getCoordinatesWithParser(path, extendLineParser)
    }

    fun getCoordinatesWithParser(path: String, lineParser: ILineParser): Int {
        return File(path).useLines { lines ->
            lines.map { lineParser.getCoordinatesFromLine(it) }
                .sum()
        }
    }
}