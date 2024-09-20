package com.stringconcat.marsrover.usecase

import com.stringconcat.marsrover.TestDispatcherContext
import com.stringconcat.marsrover.TestRoverIdGenerator
import com.stringconcat.marsrover.domain.value.Height
import com.stringconcat.marsrover.domain.value.Size
import com.stringconcat.marsrover.domain.value.Width
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test

class CreatePlateoUseCaseTest {

    @Test
    fun `when use case has been executed then context saved dispatcher`() {
        val context = TestDispatcherContext()
        val useCase = CreatePlateoUseCase(context, TestRoverIdGenerator())
        val plateoSize = Size(Width(5), Height(5))
        useCase.execute(plateoSize)
        val dispatcher = context.retrieve()
        dispatcher.plateo.size shouldBeEqual plateoSize
    }
}