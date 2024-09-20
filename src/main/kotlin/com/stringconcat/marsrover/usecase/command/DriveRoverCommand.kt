package com.stringconcat.marsrover.usecase.command

import com.stringconcat.marsrover.domain.DrivenRover

interface DriveRoverCommand {
    fun execute(rover: DrivenRover)
}