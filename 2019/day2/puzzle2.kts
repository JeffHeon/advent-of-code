package day2

import java.io.File

class IntcodeComputer {
    private var memory = mutableListOf<Int>()
    private fun dereference(reference: Int) = memory[reference]

    private fun processOperation(
        position: Int,
        operation: (Int, Int) -> Int
    ) {
        val parameter1 = memory[dereference(position + 1)]
        val parameter2 = memory[dereference(position + 2)]
        memory[dereference(position + 3)] = operation(parameter1, parameter2)
    }

    fun loadProgram(program: List<Int>) {
        memory = program.toMutableList()
    }

    fun run(): Int {
        var instructionPointer = 0
        loop@ while (instructionPointer < memory.size) {
            val opCode = memory[instructionPointer]
            when (opCode) {
                99 -> break@loop
                1 -> processOperation(instructionPointer, Integer::sum)
                2 -> processOperation(instructionPointer) { a, b -> a * b }
            }
            instructionPointer += 4
        }
        return memory[0]
    }

    fun init(noun: Int, verb: Int) {
        memory[1] = noun
        memory[2] = verb
    }
}

val program: List<Int> =
    File("input").readLines()
        .first()
        .split(",")
        .map(String::toInt)

// Color Computer
val myCoCo = IntcodeComputer()
val targetOutput = 19690720
masterControlProgram@
for (noun in 0..99) {
    for (verb in 0..99) {
        myCoCo.loadProgram(program)
        myCoCo.init(noun, verb)
        val output = myCoCo.run()
        if (output == targetOutput) {
            println("Noun $noun, Verb $verb")
            println("100 * noun + verb is ${100 * noun + verb}")
            break@masterControlProgram
        }
    }
}

println("eol")
