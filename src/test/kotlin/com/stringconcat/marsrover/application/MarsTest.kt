package com.stringconcat.marsrover.application

import arrow.core.getOrElse
import com.stringconcat.marsrover.TestDispatcherContext
import com.stringconcat.marsrover.TestRoverIdGenerator
import com.stringconcat.marsrover.domain.*
import com.stringconcat.marsrover.domain.value.*
import com.stringconcat.marsrover.usecase.*
import com.stringconcat.marsrover.usecase.command.MoveRoverCommand
import com.stringconcat.marsrover.usecase.command.TurnLeftRoverCommand
import com.stringconcat.marsrover.usecase.command.TurnRightRoverCommand
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe

import org.junit.jupiter.api.Test

class MarsTest {

    @Test
    fun `integration test - option one - controller`() {
        val commands = listOf(
            "5 5",
            "1 2 N",
            "LMLMLMLMM",
            "3 3 E",
            "MMRMMRMRRM"
        )
        val context = TestDispatcherContext()
        val executor = MarsController(
            CreatePlateoUseCase(context, TestRoverIdGenerator()),
            LandRoverUseCase(context),
            DriveRoverUseCase(context)
        )
        commands.forEach { str ->  executor.execute(str) }

        val coordinates = executor.getCoordinates()
        coordinates shouldContainExactly listOf("2 3 N", "5 1 E")
    }

    @Test
    fun `integration test - option two - use case`() {
        val dispatcherContext = TestDispatcherContext()
        val plateoSize = Size(Width(5), Height(5))
        CreatePlateoUseCase(dispatcherContext, TestRoverIdGenerator()).execute(plateoSize)

        var roverState1 = LandRoverUseCase(dispatcherContext).execute(Coordinate(1, 2), Direction.NORTH).getOrElse { null }!!
        roverState1 = DriveRoverUseCase(dispatcherContext).execute(roverState1.id, listOf(
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
        roverState1.coordinate shouldBe Coordinate(2, 3)
        roverState1.direction shouldBe Direction.NORTH

        var roverState2 = LandRoverUseCase(dispatcherContext).execute(Coordinate(3, 3), Direction.EAST).getOrElse { null } !!
        roverState2 = DriveRoverUseCase(dispatcherContext).execute(roverState2.id, listOf(
            MoveRoverCommand(),
            MoveRoverCommand(),
            TurnRightRoverCommand(),
            MoveRoverCommand(),
            MoveRoverCommand(),
            TurnRightRoverCommand(),
            MoveRoverCommand(),
            TurnRightRoverCommand(),
            TurnRightRoverCommand(),
            MoveRoverCommand(),
        )).orNull()!!
        roverState2.coordinate.shouldBe(Coordinate(5, 1))
        roverState2.direction.shouldBe(Direction.EAST)
}

    @Test
    fun `integration test - option three - domain`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())

        val rover1 = dispatcher.landRover(Coordinate(1, 2), Direction.NORTH).getOrElse { null }!!
        rover1.turnLeft()
        rover1.move()
        rover1.turnLeft()
        rover1.move()
        rover1.turnLeft()
        rover1.move()
        rover1.turnLeft()
        rover1.move()
        rover1.move()

        val rover2 = dispatcher.landRover(Coordinate(3, 3), Direction.EAST).getOrElse { null }!!
        rover2.move()
        rover2.move()
        rover2.turnRight()
        rover2.move()
        rover2.move()
        rover2.turnRight()
        rover2.move()
        rover2.turnRight()
        rover2.turnRight()
        rover2.move()

        rover1.coordinate.shouldBeEqual(Coordinate(2, 3))
        rover1.direction.shouldBeEqual(Direction.NORTH)

        rover2.coordinate.shouldBeEqual(Coordinate(5, 1))
        rover2.direction.shouldBeEqual(Direction.EAST)
    }
}

