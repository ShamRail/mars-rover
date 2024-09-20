package com.stringconcat.marsrover

import arrow.core.getOrElse
import io.kotest.matchers.equals.shouldBeEqual

import org.junit.jupiter.api.Test

class MarsTest {

//    /*
//    Пример тестового ввода:
//5 5 ← верхний правый угол плато
//1 2 N ← текущее положение и направление камеры первого марсохода
//LMLMLMLMM ← управление положением первого марсохода
//3 3 E ← текущее положение и направление камеры второго марсохода
//MMRMMRMRRM ← управление положением второго марсохода
//
//Пример тестового вывода:
//1 3 N ← конечное положение и направление камеры первого марсохода
//5 1 E ← конечное положение и направление камеры второго марсохода\
//
//
//     */
//    @Test
//    fun `integration test - option one - controller`() {
//        val commands = listOf(
//            "5 5",
//            "1 2 N",
//            "LMLMLMLMM",
//            "3 3 E",
//            "MMRMMRMRRM"
//        )
//        val executor = MarsConttoller()
//        commands.forEach { str ->  executor.execute(str) }
//
//        val coordinates = executor.getCoordinates()
//        coordinates shouldContainExactly listOf("1 3 N", "5 1 E")
//    }
//
//    @Test
//    fun `integration test - option two - use case`() {
//        val roverId = 1
//        val commands = listOf(
//            CreatePlatoCommand(5, 5),
//            LandRoverPlato(1, 2, North, roverId),
//            TurnLeft(roverId),
//            MoveCommand(roverId)
//        )
//
//        val useCase = RoverCommanderUseCase()
//        val coordinates = useCase.execute(commands)
//    }

    @Test
    fun `integration test - option three - domain`() {
        val plateo = Plateo(Size(Width(5), Height(5)))
        val dispatcher = Dispatcher(plateo)

        val rover1 = dispatcher.landRover(Coordinate(1, 2), Direction.NORTH).getOrElse { null }
        rover1?.turnLeft()
        rover1?.move()
        rover1?.turnLeft()
        rover1?.move()
        rover1?.turnLeft()
        rover1?.move()
        rover1?.turnLeft()
        rover1?.move()
        rover1?.move()

        val rover2 = dispatcher.landRover(Coordinate(3, 3), Direction.EAST).getOrElse { null }
        rover2?.move()
        rover2?.move()
        rover2?.turnRight()
        rover2?.move()
        rover2?.move()
        rover2?.turnRight()
        rover2?.move()
        rover2?.turnRight()
        rover2?.turnRight()
        rover2?.move()

        rover1?.coordinate?.shouldBeEqual(Coordinate(2, 3))
        rover1?.direction?.shouldBeEqual(Direction.NORTH)

        rover2?.coordinate?.shouldBeEqual(Coordinate(5, 1))
        rover2?.direction?.shouldBeEqual(Direction.EAST)
    }
}

