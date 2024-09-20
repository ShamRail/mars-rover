package com.stringconcat.marsrover.usecase

import com.stringconcat.marsrover.domain.Dispatcher

abstract class DispatcherContext {

    fun put(dispatcher: Dispatcher) {
        if (get() != null) {
            throw IllegalStateException("Dispatcher is already initialized")
        }
        save(dispatcher)
    }

    fun retrieve(): Dispatcher {
        if (get() == null) {
            throw IllegalStateException("Dispatcher is not initialized")
        }
        return get()!!
    }

    protected abstract fun save(dispatcher: Dispatcher)

    protected abstract fun get(): Dispatcher?

}