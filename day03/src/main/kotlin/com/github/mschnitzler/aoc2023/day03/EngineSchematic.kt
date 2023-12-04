package com.github.mschnitzler.aoc2023.day03

data class EngineSchematic(val parts: List<Part> = listOf(), val symbols: List<Symbol> = listOf()) {

    fun adjacentParts(): List<Part> {
        return parts.filter { part ->
            symbols.any { symbol ->
                symbol.x >= part.x - 1
                        && symbol.x <= part.x + part.length()
                        && symbol.y >= part.y - 1
                        && symbol.y <= part.y + 1
            }
        }.toList()
    }

    fun gears(): List<Gear> {
        return symbols
            .filter { it.symbol == "*" }
            .map { symbol ->
                parts.filter { part ->
                    symbol.x <= part.x + part.length()
                            && symbol.x >= part.x - 1
                            && symbol.y >= part.y - 1
                            && symbol.y <= part.y + 1
                }
            }
            .filter { it.size == 2 }
            .map { parts -> Gear(parts[0], parts[1]) }
    }
}

data class Part(val number: Int, val x: Int, val y: Int) {
    fun length() = number.toString().length
}

data class Symbol(val symbol: String, val x: Int, val y: Int)

data class Gear(val part1: Part, val part2: Part) {
    fun ratio() = part1.number * part2.number
}
