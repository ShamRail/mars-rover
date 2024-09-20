package com.stringconcat.marsrover

class Plateo (
    val size: Size
) {
    fun includes(coordinate: Coordinate): Boolean {
        val width = size.width.value
        val height = size.height.value
        return coordinate.x in 1..width &&
                coordinate.y in 1..height
    }
}