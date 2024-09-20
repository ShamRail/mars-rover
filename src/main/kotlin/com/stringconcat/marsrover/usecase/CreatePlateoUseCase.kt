package com.stringconcat.marsrover.usecase

import com.stringconcat.marsrover.domain.Dispatcher
import com.stringconcat.marsrover.domain.Plateo
import com.stringconcat.marsrover.domain.RoverIdGenerator
import com.stringconcat.marsrover.domain.value.Size

class CreatePlateoUseCase(private val dispatcherContext: DispatcherContext,
                          private val roverIdGenerator: RoverIdGenerator
) {
    fun execute(size: Size) {
        val dispatcher = Dispatcher(Plateo(size), roverIdGenerator)
        dispatcherContext.put(dispatcher)
    }
}