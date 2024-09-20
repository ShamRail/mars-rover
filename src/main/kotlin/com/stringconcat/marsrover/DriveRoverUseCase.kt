package com.stringconcat.marsrover

import arrow.core.Either
import arrow.core.right

class DriveRoverUseCase(private val dispatcherContext: DispatcherContext) {
    fun execute(roverId: RoverId, commands: List<DriveRoverCommand>): Either<Exception, RoverState> {
        val dispatcher = dispatcherContext.retrieve()
        return dispatcher.connectToRover(roverId)
            .map { rover ->
                commands.forEach { command -> command.execute(rover) }
                return RoverState(rover.id, rover.coordinate, rover.direction).right()
            }
    }
}