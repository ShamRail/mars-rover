package com.stringconcat.marsrover

class TestDispatcherContext : DispatcherContext() {

    private var dispatcher: Dispatcher? = null

    override fun save(dispatcher: Dispatcher) {
        this.dispatcher = dispatcher
    }

    override fun get(): Dispatcher? {
        return this.dispatcher
    }
}