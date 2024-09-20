package com.stringconcat.marsrover

import com.stringconcat.marsrover.domain.value.RoverId
import com.stringconcat.marsrover.domain.RoverIdGenerator
import kotlin.random.Random

class TestRoverIdGenerator : RoverIdGenerator {
    override fun generate(): RoverId {
        return RoverId(Random.nextInt())
    }
}