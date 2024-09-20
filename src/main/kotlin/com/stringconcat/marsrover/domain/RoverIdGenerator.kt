package com.stringconcat.marsrover.domain

import com.stringconcat.marsrover.domain.value.RoverId

interface RoverIdGenerator {
    fun generate(): RoverId
}