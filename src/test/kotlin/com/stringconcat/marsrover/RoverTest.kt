package com.stringconcat.marsrover

import com.stringconcat.marsrover.Direction.*
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.swing.text.html.HTML.Attribute.N

class RoverTest {

    @Test
    fun `when rover stays on a coordinate then it can return the same coordinate`() {
        val rover = Rover(3, 4, NORTH)
        rover.coordinate shouldBe Coordinate(3, 4)
        rover.direction shouldBe NORTH
    }

    @Test
    fun `when rover moves then it moves forward`() {
        val rover = Rover(0, 0, NORTH)
        rover.move()

        rover.coordinate shouldBe Coordinate(0, 1)
        rover.direction shouldBe NORTH

        val rover2 = Rover(1, 1, SOUTH)
        rover2.move()

        rover2.coordinate shouldBe Coordinate(1, 0)
        rover2.direction shouldBe SOUTH
    }

    @Test
    fun `when north rover turn left then the direction is West`() {
        val rover = Rover(0, 0, NORTH)
        rover.turnLeft()
        rover.direction shouldBe WEST
    }

    @Test
    fun `when south rover turn left then the direction is East`() {
        val rover = Rover(0, 0, SOUTH)
        rover.turnLeft()
        rover.direction shouldBe EAST
    }
}