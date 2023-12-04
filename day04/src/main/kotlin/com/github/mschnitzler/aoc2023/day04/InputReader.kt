package com.github.mschnitzler.aoc2023.day04

import jakarta.enterprise.context.ApplicationScoped
import java.io.File

@ApplicationScoped
class InputReader(val cardParser: CardParser) {

    fun readPile(path: String): Pile {
        val cards = ArrayList<Card>()

        File(path).useLines {
            it.map { l -> cardParser.readCard(l) }
                .forEach { c -> cards.add(c) }
        }

        return Pile(cards)
    }
}