package com.stringconcat.marsrover

import arrow.core.Either
import arrow.core.left
import arrow.core.right

class Dispatcher(val plateo: Plateo) {

    private val rovers = mutableListOf<DrivenRover>()

    fun landRover(coordinate: Coordinate, direction: Direction): Either<Exception, DrivenRover> {
        if (!plateo.includes(coordinate)) {
            return LandOutsidePlatoException("Coordinate(${coordinate.x}, ${coordinate.y}) is outside of plateo").left()
        }
        if (getOccupiedCoordinates().contains(coordinate)) {
            return LandOnOccupiedCoordinateException("Coordinate(${coordinate.x}, ${coordinate.y}) is occupied").left()
        }
        val rover = DrivenRover(this, coordinate.x, coordinate.y, direction)
        rovers.add(rover)
        return rover.right()
    }

    fun getOccupiedCoordinates() : List<Coordinate> {
        return rovers.map { rover -> rover.coordinate }
    }
}