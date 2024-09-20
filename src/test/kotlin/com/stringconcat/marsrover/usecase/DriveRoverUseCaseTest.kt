package com.stringconcat.marsrover.usecase

import arrow.core.getOrElse
import com.stringconcat.marsrover.TestDispatcherContext
import com.stringconcat.marsrover.TestRoverIdGenerator
import com.stringconcat.marsrover.domain.*
import com.stringconcat.marsrover.domain.value.*
import com.stringconcat.marsrover.usecase.command.MoveRoverCommand
import com.stringconcat.marsrover.usecase.command.TurnLeftRoverCommand
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DriveRoverUseCaseTest {

    @Test
    fun `when passed command then change rover position`() {
        val dispatcher = Dispatcher(Plateo(Size(Width(5), Height(5))), TestRoverIdGenerator())
        val roverId = dispatcher.landRover(Coordinate(1, 2), Direction.NORTH).getOrElse { null }?.id!!
        val context = TestDispatcherContext()
        context.put(dispatcher)
        val useCase = DriveRoverUseCase(context)
        val roverState = useCase.execute(roverId, listOf(
            TurnLeftRoverCommand(),
            MoveRoverCommand(),
            TurnLeftRoverCommand(),
            MoveRoverCommand(),
            TurnLeftRoverCommand(),
            MoveRoverCommand(),
            TurnLeftRoverCommand(),
            MoveRoverCommand(),
            MoveRoverCommand()
        )).orNull()!!
        roverState.coordinate shouldBe Coordinate(2, 3)
        roverState.direction shouldBe Direction.NORTH
    }
}