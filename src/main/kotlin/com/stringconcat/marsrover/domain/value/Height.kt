package com.stringconcat.marsrover.domain.value

data class Height(
    val value: Int
) {
    init {
        if (value < 1) {
            throw IllegalArgumentException("Height must be positive")
        }
    }
}