package com.stringconcat.marsrover

class RoverIsNotFoundException(roverId: RoverId) : RuntimeException("Rover $roverId is not found")