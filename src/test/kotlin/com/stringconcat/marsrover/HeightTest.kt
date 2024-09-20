package com.stringconcat.marsrover

import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.equals.shouldNotBeEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class HeightTest {

    @Test
    fun `when create with positive value then height must be same`() {
        val width = Height(5)
        width.value shouldBe 5
    }

    @Test
    fun `when create with negative value then throw exception`() {
        val exception = assertThrows<IllegalArgumentException> { Height(-1)  }
        exception.message shouldBe "Height must be positive"
    }


    @Test
    fun `two heights are equal if values are the same`() {
        Height(5) shouldBeEqual Height(5)
    }

    @Test
    fun `two heights are not equal if values are NOT the same`() {
        Height(5) shouldNotBeEqual  Height(4)
    }
}