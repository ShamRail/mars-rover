package com.stringconcat.marsrover

class MoveRoverCommand : DriveRoverCommand {
    override fun execute(rover: DrivenRover) {
        rover.move()
    }
}