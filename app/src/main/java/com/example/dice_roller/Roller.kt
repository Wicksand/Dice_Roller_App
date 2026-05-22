package com.example.dice_roller

import kotlin.random.Random

class Roller {

    val dice = mapOf(
        "d4" to 5,
        "d6" to 7,
        "d8" to 9,
        "d10" to 11,
        "d12" to 13,
        "d20" to 21,
    )
    fun roll(key: String ): Int{
        val sides = dice[key] ?: return 0
        return Random.nextInt(1, sides)

    }
}