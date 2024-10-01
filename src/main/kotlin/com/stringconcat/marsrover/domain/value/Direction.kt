package com.stringconcat.marsrover.domain.value

enum class Direction {
    NORTH, EAST, SOUTH, WEST;

    fun turnLeft(): Direction {
        return when (this) {
            NORTH -> WEST
            WEST-> SOUTH
            SOUTH-> EAST
            EAST-> NORTH
        }
    }

    fun turnRight(): Direction {
        return when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }
}