package day4

import jeff.second

fun main() {
    val range = 172851..675869
    val eligibleCount = range.count { eligiblePassword(it) }
    println("eligibleCount $eligibleCount")
}

fun eligiblePassword(password: Int): Boolean {
    val digits = digitize(password)
    return hasAtLeastExactlyTwoIdenticalDigits(digits) && digitsDoNotDecrease(digits)
}

fun hasAtLeastExactlyTwoIdenticalDigits(digits: List<Int>): Boolean {
    val digitCounts = mutableMapOf<Int, Int>()
    for (digit in digits) {
        digitCounts[digit] = digitCounts.getOrDefault(digit, 0) + 1
    }

    return digitCounts.containsValue(2)
}

fun digitsDoNotDecrease(digits: List<Int>): Boolean {
    return !digits.windowed(2, 1).any { pair -> pair.first() > pair.second() }
}

fun digitize(number: Int) = number.toString().toList().map { it.toInt() }
