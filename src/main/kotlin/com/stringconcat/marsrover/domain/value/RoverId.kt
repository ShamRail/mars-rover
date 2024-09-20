package com.stringconcat.marsrover.domain.value

data class RoverId(private val id: Int) {
    override fun toString(): String {
        return id.toString()
    }
}