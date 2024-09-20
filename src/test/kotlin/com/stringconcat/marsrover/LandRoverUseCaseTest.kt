package com.stringconcat.marsrover

import arrow.core.getOrElse
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LandRoverUseCaseTest {

    @Test
    fun `when land rover then rover placed to corresponding coordinates`() {
        val context = TestDispatcherContext()
        context.put(Dispatcher(Plateo(Size(Width(5), Height(5))), TestRoverIdGenerator()))
        val useCase = LandRoverUseCase(context)
        val coordinate = Coordinate(2, 2)
        val direction = Direction.NORTH
        val roverState = useCase.execute(coordinate, direction).getOrElse { null }
        roverState?.coordinate shouldBe coordinate
        roverState?.direction shouldBe direction
    }
}