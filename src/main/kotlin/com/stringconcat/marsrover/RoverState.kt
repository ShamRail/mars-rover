package com.stringconcat.marsrover

data class RoverState(
    val id: RoverId,
    val coordinate: Coordinate,
    val direction: Direction
)