package com.stringconcat.marsrover

class CreatePlateoUseCase(private val dispatcherContext: DispatcherContext,
                          private val roverIdGenerator: RoverIdGenerator) {
    fun execute(size: Size) {
        val dispatcher = Dispatcher(Plateo(size), roverIdGenerator)
        dispatcherContext.put(dispatcher)
    }
}