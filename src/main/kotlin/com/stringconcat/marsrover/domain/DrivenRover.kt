package com.stringconcat.marsrover.domain

import com.stringconcat.marsrover.domain.value.Direction
import com.stringconcat.marsrover.domain.value.RoverId

class DrivenRover(
    private val dispatcher: Dispatcher,
    id: RoverId,
    x: Int, y: Int, direction: Direction
) : Rover(id, x, y, direction) {

    override fun move() {
        val nextCoordinate = nextCoordinate()
        if (!dispatcher.plateo.includes(nextCoordinate)) {
            return
        }
        if (dispatcher.getOccupiedCoordinates().contains(nextCoordinate)) {
            return
        }
        super.move()
    }
}