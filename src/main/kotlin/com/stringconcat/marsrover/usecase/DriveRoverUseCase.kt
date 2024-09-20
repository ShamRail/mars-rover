package com.stringconcat.marsrover.usecase

import arrow.core.Either
import arrow.core.right
import com.stringconcat.marsrover.domain.value.RoverId
import com.stringconcat.marsrover.usecase.command.DriveRoverCommand

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