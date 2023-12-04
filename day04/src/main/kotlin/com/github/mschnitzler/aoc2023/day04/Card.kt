package com.github.mschnitzler.aoc2023.day04

import kotlin.math.*

data class Card(val id: Int, val winningNumbers: List<Int>, val pickedNumbers: List<Int>) {

    fun points(): Int {
        val numberOfMatches = numberOfMatches()
        return when (numberOfMatches) {
            0 -> 0
            else -> return 2.0.pow(numberOfMatches - 1).toInt()
        }
    }

    fun numberOfMatches(): Int = (winningNumbers intersect pickedNumbers).size
}

data class Pile(val cards: List<Card>) {

    fun points() = cards.map { it.points() }.sum()

    fun pileWithWinningCards(): Map<Int, Int> {
        val map = cards.map { it.id to 1 }.toMap()
        val mmap = map.toMutableMap()

        cards.forEach { card ->
            val matches = card.numberOfMatches()
            if (matches > 0) {
                val winningStart = cards.indexOf(card) + 1
                val winningEnd = min(winningStart + matches - 1, cards.size)

                (winningStart..winningEnd)
                    .map { cards[it].id }
                    .forEach {
                        val old = mmap.getOrDefault(it, 0)
                        val new = old + mmap.getOrDefault(card.id, 0)
                        mmap.put(it, new)
                    }
            }
        }
        return mmap
    }
}
