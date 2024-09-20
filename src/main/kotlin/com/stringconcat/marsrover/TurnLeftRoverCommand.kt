package com.stringconcat.marsrover

class TurnLeftRoverCommand : DriveRoverCommand {
    override fun execute(rover: DrivenRover) {
        rover.turnLeft()
    }
}