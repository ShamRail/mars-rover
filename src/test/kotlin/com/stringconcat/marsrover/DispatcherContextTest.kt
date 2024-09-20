package com.stringconcat.marsrover

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DispatcherContextTest {

    @Test
    fun `when put dispatcher to context then get the same dispatcher`() {
        val dispatcher = Dispatcher(Plateo(Size(Width(5), Height(5))), TestRoverIdGenerator())
        val dispatcherContext = TestDispatcherContext()
        dispatcherContext.put(dispatcher)
        dispatcherContext.retrieve() shouldBe dispatcher
    }

    @Test
    fun `when put dispatcher to context twice then get exception`() {
        val dispatcher = Dispatcher(Plateo(Size(Width(5), Height(5))), TestRoverIdGenerator())
        val dispatcherContext = TestDispatcherContext()
        dispatcherContext.put(dispatcher)
        val exception = shouldThrow<IllegalStateException> { dispatcherContext.put(dispatcher)  }
        exception.message shouldBe "Dispatcher is already initialized"
    }

    @Test
    fun `when get from empty context then get exception`() {
        val dispatcherContext = TestDispatcherContext()
        val exception = shouldThrow<IllegalStateException> { dispatcherContext.retrieve() }
        exception.message shouldBe "Dispatcher is not initialized"
    }
}