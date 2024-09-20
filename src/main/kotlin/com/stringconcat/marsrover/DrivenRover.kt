package com.stringconcat.marsrover

class DrivenRover(
    private val dispatcher: Dispatcher,
    x: Int, y: Int, direction: Direction) : Rover(x, y, direction) {

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