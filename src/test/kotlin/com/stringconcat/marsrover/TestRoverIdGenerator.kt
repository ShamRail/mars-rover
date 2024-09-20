package com.stringconcat.marsrover

import kotlin.random.Random

class TestRoverIdGenerator : RoverIdGenerator {
    override fun generate(): RoverId {
        return RoverId(Random.nextInt())
    }
}