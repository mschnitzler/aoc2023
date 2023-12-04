package com.github.mschnitzler.aoc2023.day03

import jakarta.enterprise.context.ApplicationScoped
import java.io.File

@ApplicationScoped
class EngineSchematicParser {

    val parts = ArrayList<Part>()
        get() = field
    val symbols = ArrayList<Symbol>()
        get() = field

    val regexParts = """([\d]+)""".toRegex()
    val regexSymbols = """([^0-9.])""".toRegex()

    fun parseFile(path: String): EngineSchematic {
        File(path).useLines {
            val seq = it.withIndex()
            seq.forEach { iv ->
                processLine(iv)
            }
        }
        return EngineSchematic(parts, symbols)
    }

    fun processLine(value: IndexedValue<String>) {
        extractParts(value)
        extractSymbols(value)
    }

    private fun extractParts(value: IndexedValue<String>) {
        val matches = regexParts.findAll(value.value)
        matches.forEach { m ->
            val n = m.value
            val x = m.range.first
            val y = value.index

            val part = Part(n.toInt(), x, y)
            parts.add(part)
        }
    }

    private fun extractSymbols(value: IndexedValue<String>) {
        val matches = regexSymbols.findAll(value.value)
        matches.forEach { m ->
            val s = m.value
            val x = m.range.first
            val y = value.index

            val symbol = Symbol(s, x, y)
            symbols.add(symbol)
        }
    }
}