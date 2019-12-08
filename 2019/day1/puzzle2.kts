package day1

import java.io.File

var fuelRequired =
    File("input").readLines().map { moduleMass ->
        moduleFuel(moduleMass.toInt())
    }.sum()

print("Fuel requirement: $fuelRequired")

fun moduleFuel(moduleMass: Int): Int {
    tailrec fun fuel(mass: Int, totalFuel: Int): Int {
        val fuel = mass/ 3 - 2
        if (fuel <= 0) {
            return totalFuel
        }
        return fuel(fuel, totalFuel + fuel)
    }

    return fuel(moduleMass, 0)
}