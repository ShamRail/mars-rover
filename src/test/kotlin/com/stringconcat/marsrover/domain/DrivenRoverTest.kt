package com.stringconcat.marsrover.domain

import arrow.core.getOrElse
import com.stringconcat.marsrover.TestRoverIdGenerator
import com.stringconcat.marsrover.domain.value.*
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test

class DrivenRoverTest {

    @Test
    fun `when move to free coordinate then rover change coordinate`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        val rover = dispatcher.landRover(Coordinate(2, 2), Direction.NORTH).getOrElse { null }
        rover?.move()
        rover?.coordinate?.shouldBeEqual(Coordinate(2, 3))
    }

    @Test
    fun `when move to outside plateo then rover DONT change coordinate`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        val rover = dispatcher.landRover(Coordinate(5, 5), Direction.NORTH).getOrElse { null }
        rover?.move()
        rover?.coordinate?.shouldBeEqual(Coordinate(5, 5))
    }

    @Test
    fun `when move to occupied coordinate then rover DONT change coordinate`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo, TestRoverIdGenerator())
        dispatcher.landRover(Coordinate(2, 2), Direction.NORTH)
        val rover = dispatcher.landRover(Coordinate(2, 1), Direction.NORTH).getOrElse { null }
        rover?.move()
        rover?.coordinate?.shouldBeEqual(Coordinate(2, 1))
    }
}