package com.stringconcat.marsrover.usecase.command

import com.stringconcat.marsrover.domain.DrivenRover

class TurnRightRoverCommand : DriveRoverCommand {
    override fun execute(rover: DrivenRover) {
        rover.turnRight()
    }
}