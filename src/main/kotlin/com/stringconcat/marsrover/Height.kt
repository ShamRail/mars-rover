package com.stringconcat.marsrover

data class Height(
    val value: Int
) {
    init {
        if (value < 1) {
            throw IllegalArgumentException("Height must be positive")
        }
    }
}