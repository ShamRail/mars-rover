package com.stringconcat.marsrover.domain

import com.stringconcat.marsrover.domain.value.Coordinate
import com.stringconcat.marsrover.domain.value.Direction
import com.stringconcat.marsrover.domain.value.RoverId

open class Rover(
    val id: RoverId,
    var coordinate: Coordinate,
    var direction: Direction
) {

    fun nextCoordinate(): Coordinate {
        return when (direction) {
            Direction.SOUTH -> coordinate.decY()
            Direction.NORTH -> coordinate.incY()
            Direction.EAST -> coordinate.incX()
            Direction.WEST -> coordinate.decX()
        }
    }

    open fun move() {
        coordinate = nextCoordinate()
    }

    fun turnLeft() {
        direction = direction.turnLeft()
    }

    fun turnRight() {
        direction = direction.turnRight()
    }
}