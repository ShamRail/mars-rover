package com.stringconcat.marsrover.usecase.command

import com.stringconcat.marsrover.domain.DrivenRover

class TurnLeftRoverCommand : DriveRoverCommand {
    override fun execute(rover: DrivenRover) {
        rover.turnLeft()
    }
}