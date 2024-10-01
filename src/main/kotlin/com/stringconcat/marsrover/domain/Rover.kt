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
        direction = when (direction) {
            Direction.NORTH -> Direction.WEST
            Direction.WEST-> Direction.SOUTH
            Direction.SOUTH-> Direction.EAST
            Direction.EAST-> Direction.NORTH
        }
    }

    fun turnRight() {
        direction = when (direction) {
            Direction.NORTH -> Direction.EAST
            Direction.EAST -> Direction.SOUTH
            Direction.SOUTH -> Direction.WEST
            Direction.WEST -> Direction.NORTH
        }
    }
}