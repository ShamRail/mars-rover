package com.stringconcat.marsrover

import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test

class PlateoTest {

    @Test
    fun `when create plateo then size must be as specified`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        plateo.size shouldBeEqual Size(Width(5), Height(5))
    }

    @Test
    fun `when passed coordinate inside plateo then includes return true`() {
        val plateo = Plateo(Size(Width(2), Height(2)))
        plateo.includes(Coordinate(1, 1)).shouldBeTrue()
        plateo.includes(Coordinate(1, 2)).shouldBeTrue()
        plateo.includes(Coordinate(2, 1)).shouldBeTrue()
        plateo.includes(Coordinate(2, 2)).shouldBeTrue()
    }

    @Test
    fun `when passed coordinate outside plateo then includes return false`() {
        val plateo = Plateo(Size(Width(2), Height(2)))
        plateo.includes(Coordinate(0, 1)).shouldBeFalse()
        plateo.includes(Coordinate(1, 0)).shouldBeFalse()
        plateo.includes(Coordinate(3, 1)).shouldBeFalse()
        plateo.includes(Coordinate(2, 3)).shouldBeFalse()
    }
}