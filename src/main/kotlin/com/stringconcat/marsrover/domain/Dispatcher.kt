package com.stringconcat.marsrover.domain

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.stringconcat.marsrover.domain.exception.LandOnOccupiedCoordinateException
import com.stringconcat.marsrover.domain.exception.LandOutsidePlatoException
import com.stringconcat.marsrover.domain.exception.RoverIsNotFoundException
import com.stringconcat.marsrover.domain.value.Coordinate
import com.stringconcat.marsrover.domain.value.Direction
import com.stringconcat.marsrover.domain.value.RoverId

class Dispatcher(val plateo: Plateo, private val roverIdGenerator: RoverIdGenerator) {

    private val rovers = mutableMapOf<RoverId, DrivenRover>()

    fun landRover(coordinate: Coordinate, direction: Direction): Either<Exception, DrivenRover> {
        if (!plateo.includes(coordinate)) {
            return LandOutsidePlatoException("Coordinate(${coordinate.x}, ${coordinate.y}) is outside of plateo").left()
        }
        if (getOccupiedCoordinates().contains(coordinate)) {
            return LandOnOccupiedCoordinateException("Coordinate(${coordinate.x}, ${coordinate.y}) is occupied").left()
        }
        val id = roverIdGenerator.generate()
        val rover = DrivenRover(
            this, id,
            coordinate.x, coordinate.y, direction
        )
        rovers[id] = rover
        return rover.right()
    }

    fun getOccupiedCoordinates() : List<Coordinate> {
        return rovers.values.map { rover -> rover.coordinate }
    }

    fun connectToRover(roverId: RoverId): Either<Exception, DrivenRover> {
        if (!rovers.containsKey(roverId)) {
            return RoverIsNotFoundException(roverId).left()
        }
        return rovers[roverId]!!.right()
    }
}