package com.stringconcat.marsrover.domain.value

enum class Direction {
    NORTH, EAST, SOUTH, WEST;

    fun turnLeft(): Direction {
        return when (this) {
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
            EAST -> NORTH
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

    fun delta(): Delta {
        return when (this) {
            NORTH -> Delta(0, 1)
            SOUTH -> Delta(0, -1)
            WEST -> Delta(-1, 0)
            EAST -> Delta(1, 0)
        }
    }
}