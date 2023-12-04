package com.github.mschnitzler.aoc2023.day02

data class Game(val id: Int = 0, val gameSets: List<Draw> = emptyList()) {

    fun isValid(gameConfiguration: GameConfiguration): Boolean {
        return gameSets.all { it.isValid(gameConfiguration) }
    }

    fun getMinimalGameConfiguration(): GameConfiguration {
        val blue = gameSets.map { it.blue }.max()
        val red = gameSets.map { it.red }.max()
        val green = gameSets.map { it.green }.max()
        return GameConfiguration(blue = blue, red = red, green = green)
    }
}

data class Draw(val blue: Int, val green: Int, val red: Int) {

    fun isValid(gameConfiguration: GameConfiguration): Boolean {
        return blue <= gameConfiguration.blue
                && green <= gameConfiguration.green
                && red <= gameConfiguration.red
    }
}

data class GameConfiguration(val blue: Int = 0, val green: Int = 0, val red: Int = 0) {

    fun power(): Int {
        return blue * red * green
    }
}
