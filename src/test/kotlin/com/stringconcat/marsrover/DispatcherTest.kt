package com.stringconcat.marsrover

import arrow.core.handleError
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Test

class DispatcherTest {

    @Test
    fun `when no rovers on plateo then Dispatcher return empty occupied coordinates list`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        dispatcher.getOccupiedCoordinates().shouldBeEmpty()
    }

    @Test
    fun `when land rover on correct coordinates then Dispatcher return driven rover`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        val roverCoordinate = Coordinate(1, 2)
        val roverDirection = Direction.NORTH
        val drivenRover = dispatcher.landRover(roverCoordinate, roverDirection).orNull()!!
        drivenRover.coordinate shouldBe roverCoordinate
        drivenRover.direction shouldBe roverDirection
        dispatcher.getOccupiedCoordinates().shouldContainExactly(roverCoordinate)
    }

    @Test
    fun `when land rover outside then Dispatcher return land outside plato exception`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        val result = dispatcher.landRover(Coordinate(6, 6), Direction.NORTH)
        result.isLeft() shouldBe true
        result.handleError { e ->
                e.shouldBeTypeOf<LandOutsidePlatoException>()
                e.message?.shouldBeEqual("Coordinate(6, 6) is outside of plateo")
            }
    }

    @Test
    fun `when land rover on occupied coordinate then Dispatcher return land on occupied coordinate exception`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        val conflictCoordinate = Coordinate(3, 3)
        dispatcher.landRover(conflictCoordinate, Direction.NORTH)
        val result = dispatcher.landRover(conflictCoordinate, Direction.NORTH)
        result.isLeft() shouldBe true
        result.handleError { e ->
            e.shouldBeTypeOf<LandOnOccupiedCoordinateException>()
            e.message?.shouldBeEqual("Coordinate(3, 3) is occupied")
        }
    }

    @Test
    fun `when land rover then can connect to id`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        val roverCoordinate = Coordinate(1, 2)
        val roverDirection = Direction.NORTH
        val roverId = dispatcher.landRover(roverCoordinate, roverDirection).orNull()?.id!!
        val connectedRover = dispatcher.connectToRover(roverId).orNull()!!
        connectedRover.coordinate shouldBe roverCoordinate
        connectedRover.direction shouldBe roverDirection
    }

    @Test
    fun `when rover is not exists then connect return exception`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        val result = dispatcher.connectToRover(RoverId(1))
        result.isLeft() shouldBe true
        result.handleError { e ->
            e.shouldBeTypeOf<RoverIsNotFoundException>()
            e.message?.shouldBeEqual("Rover 1 is not found")
        }
    }
}