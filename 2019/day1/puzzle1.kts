package day1

import java.io.File

var fuelRequired =
    File("input").readLines().map { moduleMass ->
        moduleMass.toInt() / 3 - 2
    }.sum()

println("Fuel requirement: $fuelRequired")
