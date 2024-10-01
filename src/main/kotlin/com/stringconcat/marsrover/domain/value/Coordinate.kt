package com.stringconcat.marsrover.domain.value

data class Coordinate(
    val x: Int,
    val y: Int
) {
    fun incX(): Coordinate {
        return Coordinate(x.inc(), y)
    }

    fun decX() = Coordinate(x.dec(), y)
    fun incY() = Coordinate(x, y.inc())
    fun decY() = Coordinate(x, y.dec())

    fun move(delta: Delta): Coordinate {
        return Coordinate(x + delta.dx, y + delta.dy)
    }
}