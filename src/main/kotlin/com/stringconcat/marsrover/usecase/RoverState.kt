package com.stringconcat.marsrover.usecase

import com.stringconcat.marsrover.domain.value.Coordinate
import com.stringconcat.marsrover.domain.value.Direction
import com.stringconcat.marsrover.domain.value.RoverId

data class RoverState(
    val id: RoverId,
    val coordinate: Coordinate,
    val direction: Direction
)