package com.stringconcat.marsrover

class MarsController(
    private val createPlateoUseCase: CreatePlateoUseCase,
    private val landRoverUseCase: LandRoverUseCase,
    private val driveRoverUseCase: DriveRoverUseCase
) {

    private var roverState: RoverState? = null

    private val handledRovers: MutableList<RoverState> = mutableListOf()

    fun execute(input: String) {
        val parts = input.split(" ")
        if (parts.size == 2) {
            val width = Width(Integer.parseInt(parts[0]))
            val height = Height(Integer.parseInt(parts[1]))
            createPlateoUseCase.execute(Size(width, height))
            return
        }
        if (parts.size == 3) {
            val x = Integer.parseInt(parts[0])
            val y = Integer.parseInt(parts[1])
            val direction = Direction.entries.first { d -> d.toString().startsWith(parts[2]) }
            roverState = landRoverUseCase.execute(Coordinate(x, y), direction).orNull()
            return
        }
        val commands = input.toCharArray().map { c -> when(c) {
            'L' -> TurnLeftRoverCommand()
            'R' -> TurnRightRoverCommand()
            else -> MoveRoverCommand()
        } }.toList()
        roverState = driveRoverUseCase.execute(roverState?.id!!, commands).orNull()
        handledRovers.add(roverState!!)
    }

    fun getCoordinates(): List<String> {
        return handledRovers.map {
            rover -> "${rover.coordinate.x} ${rover.coordinate.y} ${rover.direction.toString().substring(0, 1)}"
        }
    }
}