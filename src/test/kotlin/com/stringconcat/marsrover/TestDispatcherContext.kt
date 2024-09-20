package com.stringconcat.marsrover

import com.stringconcat.marsrover.domain.Dispatcher
import com.stringconcat.marsrover.usecase.DispatcherContext

class TestDispatcherContext : DispatcherContext() {

    private var dispatcher: Dispatcher? = null

    override fun save(dispatcher: Dispatcher) {
        this.dispatcher = dispatcher
    }

    override fun get(): Dispatcher? {
        return this.dispatcher
    }
}