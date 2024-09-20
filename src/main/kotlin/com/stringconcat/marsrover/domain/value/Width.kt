package com.stringconcat.marsrover.domain.value

data class Width(
    val value: Int
) {
    init {
        if (value < 1) {
            throw IllegalArgumentException("Width must be positive")
        }
    }
}