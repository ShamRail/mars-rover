package com.stringconcat.marsrover

class TurnRightRoverCommand : DriveRoverCommand {
    override fun execute(rover: DrivenRover) {
        rover.turnRight()
    }
}