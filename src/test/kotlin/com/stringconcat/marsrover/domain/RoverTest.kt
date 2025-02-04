package com.stringconcat.marsrover.domain

import com.stringconcat.marsrover.domain.value.Direction.*
import com.stringconcat.marsrover.domain.value.Coordinate
import com.stringconcat.marsrover.domain.value.RoverId
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `when rover stays on a coordinate then it can return the same coordinate`() {
        val rover = Rover(RoverId(1), Coordinate(3, 4), NORTH)
        rover.coordinate shouldBe Coordinate(3, 4)
        rover.direction shouldBe NORTH
    }

    @Test
    fun `when rover moves then it moves forward`() {
        val rover = Rover(RoverId(1), Coordinate(0, 0), NORTH)
        rover.move()

        rover.coordinate shouldBe Coordinate(0, 1)
        rover.direction shouldBe NORTH

        val rover2 = Rover(RoverId(1), Coordinate(1, 1), SOUTH)
        rover2.move()

        rover2.coordinate shouldBe Coordinate(1, 0)
        rover2.direction shouldBe SOUTH
    }

    @Test
    fun `when north rover turn left then the direction is West`() {
        val rover = Rover(RoverId(1), Coordinate(0, 0), NORTH)
        rover.turnLeft()
        rover.direction shouldBe WEST
    }

    @Test
    fun `when south rover turn left then the direction is East`() {
        val rover = Rover(RoverId(1), Coordinate(0, 0), SOUTH)
        rover.turnLeft()
        rover.direction shouldBe EAST
    }

    @Test
    fun `when north rover turn right then the direction is East`() {
        val rover = Rover(RoverId(1), Coordinate(0, 0), NORTH)
        rover.turnRight()
        rover.direction shouldBe EAST
    }

    @Test
    fun `when east rover turn right then the direction is South`() {
        val rover = Rover(RoverId(1), Coordinate(0, 0), EAST)
        rover.turnRight()
        rover.direction shouldBe SOUTH
    }

    @Test
    fun `when south rover turn right then the direction is West`() {
        val rover = Rover(RoverId(1), Coordinate(0, 0), SOUTH)
        rover.turnRight()
        rover.direction shouldBe WEST
    }

    @Test
    fun `when west rover turn right then the direction is North`() {
        val rover = Rover(RoverId(1), Coordinate(0, 0), WEST)
        rover.turnRight()
        rover.direction shouldBe NORTH
    }

    @Test
    fun `when call next coordinate then returns new coordinate without moving`() {
        val rover = Rover(RoverId(1), Coordinate(0, 0), EAST)
        val nextCoordinate = rover.nextCoordinate()
        nextCoordinate shouldBe Coordinate(1, 0)
        rover.coordinate shouldBe Coordinate(0, 0)
    }
}