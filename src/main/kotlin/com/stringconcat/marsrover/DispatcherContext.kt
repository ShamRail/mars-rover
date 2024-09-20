package com.stringconcat.marsrover

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