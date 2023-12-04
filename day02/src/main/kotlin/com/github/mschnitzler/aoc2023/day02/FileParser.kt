package com.github.mschnitzler.aoc2023.day02

import jakarta.enterprise.context.ApplicationScoped
import java.io.File

@ApplicationScoped
class FileParser(
    private val lineParser: LineParser
) {

    fun getSumOfIdsForValidGames(path: String, gameConfiguration: GameConfiguration): Int {
        val games = getGames(path)

        return games
            .filter { it.isValid(gameConfiguration) }
            .map { it.id }
            .sum()
    }

    fun getPower(path: String): Int {
        val games = getGames(path)

        return games
            .map { it.getMinimalGameConfiguration() }
            .map { it.power() }
            .sum()
    }

    private fun getGames(path: String): List<Game> {
        return File(path).useLines { lines ->
            lines.map { lineParser.parseGame(it) }
                .toList()
        }
    }
}