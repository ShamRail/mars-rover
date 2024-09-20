package com.stringconcat.marsrover.domain

import com.stringconcat.marsrover.domain.value.Coordinate
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class CoordinateTest {

    @Test
    fun `two coordinates are equal if values are the same`() {
        Coordinate(0, 0) shouldBe Coordinate(0, 0)
        Coordinate(1, 0) shouldBe Coordinate(1, 0)
    }

    @Test
    fun `two coordinates are not equal if values are NOT the same`() {
        Coordinate(0, 0) shouldNotBe  Coordinate(99, 0)
        Coordinate(1, 0) shouldNotBe  Coordinate(0, 99)
    }

    @Test
    fun `when x is increased then value should be changed`() {
        Coordinate(0, 1).incX() shouldBe Coordinate(1, 1)
        Coordinate(0, 1).decX() shouldBe Coordinate(-1, 1)
        Coordinate(0, 1).incY() shouldBe Coordinate(0, 2)
        Coordinate(0, 1).decY() shouldBe Coordinate(0, 0)
    }

}
