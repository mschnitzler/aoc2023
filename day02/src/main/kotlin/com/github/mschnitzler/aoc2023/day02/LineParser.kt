package com.github.mschnitzler.aoc2023.day02

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class LineParser {

    val regexGame = """Game (?<gameId>\d+): (?<gameSets>.*)""".toRegex()
    val regexDraw = """(((?<green>\d+) green|(?<red>\d+) red|(?<blue>\d+) blue)(,\s)?)*""".toRegex()

    fun parseGame(line: String): Game {
        val match = regexGame.find(line)!!

        val gameId = extractGameId(match)
        val gameSets = extractGameSets(match)

        return Game(gameId, gameSets)
    }

    fun extractGameId(match: MatchResult): Int {
        val gameId = match.groups["gameId"]?.value
        return gameId?.toInt() ?: 0
    }

    fun extractGameSets(match: MatchResult): List<Draw> {
        val gameLine = match.groups["gameSets"]?.value
        val drawLine = gameLine?.split(';')

        var draws: List<Draw> = listOf()
        drawLine?.forEach { draws += parseDraw(it) }
        return draws
    }

    fun parseDraw(drawLine: String): Draw {
        val match = regexDraw.find(drawLine.trim())
        
        val blue = match?.groups?.get("blue")?.value?.toInt() ?: 0
        val red = match?.groups?.get("red")?.value?.toInt() ?: 0
        val green = match?.groups?.get("green")?.value?.toInt() ?: 0

        return Draw(blue = blue, red = red, green = green)
    }
}