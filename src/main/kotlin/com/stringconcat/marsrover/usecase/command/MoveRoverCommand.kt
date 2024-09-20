package com.stringconcat.marsrover.usecase.command

import com.stringconcat.marsrover.domain.DrivenRover

class MoveRoverCommand : DriveRoverCommand {
    override fun execute(rover: DrivenRover) {
        rover.move()
    }
}