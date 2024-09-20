package com.stringconcat.marsrover

data class RoverId(private val id: Int) {
    override fun toString(): String {
        return id.toString()
    }
}