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
        return coordinate.move(direction.delta())
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