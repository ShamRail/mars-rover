package com.stringconcat.marsrover.domain

import com.stringconcat.marsrover.domain.value.Width
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.equals.shouldNotBeEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WidthTest {

    @Test
    fun `when create with positive value then width must be same`() {
        val width = Width(5)
        width.value shouldBe 5
    }

    @Test
    fun `when create with negative value then throw exception`() {
        val exception = assertThrows<IllegalArgumentException> { Width(-1)  }
        exception.message shouldBe "Width must be positive"
    }

    @Test
    fun `two widths are equal if values are the same`() {
        Width(5) shouldBeEqual Width(5)
    }

    @Test
    fun `two widths are not equal if values are NOT the same`() {
        Width(5) shouldNotBeEqual  Width(4)
    }
}