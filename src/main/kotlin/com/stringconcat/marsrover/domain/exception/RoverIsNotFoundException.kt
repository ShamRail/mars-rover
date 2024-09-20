package com.stringconcat.marsrover.domain.exception

import com.stringconcat.marsrover.domain.value.RoverId

class RoverIsNotFoundException(roverId: RoverId) : RuntimeException("Rover $roverId is not found")