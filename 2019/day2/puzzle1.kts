package day2

import java.io.File

fun dereference(reference: Int) = program[reference]

fun processOperation(
    position: Int,
    operation: (Int, Int) -> Int
) {
    val a = program[dereference(position + 1)]
    val b = program[dereference(position + 2)]
    program[dereference(position + 3)] = operation(a, b)
}

var program: MutableList<Int> =
    File("input").readLines()
        .first()
        .split(",")
        .map { it -> it.toInt() }
        .toMutableList()

// Initialization
program[1] = 12
program[2] = 2

var position = 0
loop@ while (position < program.size) {
    var opCode = program[position]
    when (opCode) {
        99 -> break@loop
        1 -> processOperation(position, Integer::sum)
        2 -> processOperation(position) { a, b -> a * b }
    }
    position += 4
}

println("Full Program: $program")
println()
println("Position 0: ${program[0]}")
