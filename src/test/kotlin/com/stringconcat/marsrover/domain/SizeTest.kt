package com.stringconcat.marsrover.domain

import com.stringconcat.marsrover.domain.value.Height
import com.stringconcat.marsrover.domain.value.Size
import com.stringconcat.marsrover.domain.value.Width
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.equals.shouldNotBeEqual
import org.junit.jupiter.api.Test

class SizeTest {

    @Test
    fun `when create size with width and height then get same values`() {
        val size = Size(Width(5), Height(5))
        size.width shouldBeEqual Width(5)
        size.height shouldBeEqual Height(5)
    }

    @Test
    fun `two sizes are equal if values are the same`() {
        Size(Width(5), Height(5)) shouldBeEqual Size(Width(5), Height(5))
        Size(Width(1), Height(2)) shouldBeEqual Size(Width(1), Height(2))
    }

    @Test
    fun `two sizes are not equal if values are NOT the same`() {
        Size(Width(1), Height(5)) shouldNotBeEqual  Size(Width(2), Height(5))
        Size(Width(5), Height(1)) shouldNotBeEqual Size(Width(5), Height(2))
        Size(Width(5), Height(5)) shouldNotBeEqual Size(Width(6), Height(7))
    }
}