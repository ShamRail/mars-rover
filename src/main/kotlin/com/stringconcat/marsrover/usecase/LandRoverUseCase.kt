package com.stringconcat.marsrover.usecase

import arrow.core.Either
import com.stringconcat.marsrover.domain.value.Coordinate
import com.stringconcat.marsrover.domain.value.Direction

class LandRoverUseCase(private val dispatcherContext: DispatcherContext) {
    fun execute(coordinate: Coordinate, direction: Direction) : Either<Exception, RoverState> {
        val dispatcher = dispatcherContext.retrieve()
        val rover = dispatcher.landRover(coordinate, direction)
        return rover.map { RoverState(it.id, it.coordinate, it.direction) }
    }
}