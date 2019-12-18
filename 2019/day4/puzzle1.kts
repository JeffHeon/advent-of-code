package day4

val range = 172851..675869

println("Password range $range")

// It is a six-digit number.
// The value is within the range given in your puzzle input.

// Two adjacent digits are the same (like 22 in 122345).
// Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).

//Other than the range rule, the following are true:
//
// 111111 meets these criteria (double 11, never decreases).
// 223450 does not meet these criteria (decreasing pair of digits 50).
//  23789 does not meet these criteria (no double).
//
// How many different passwords within the range given in your puzzle input meet these criteria?

val eligibleCount = range.count { eligiblePassword(it) }
println("eligibleCount $eligibleCount")

fun eligiblePassword(password: Int): Boolean {
    val digits = digitize(password)
    return hasAtLeastTwoIdenticalDigits(digits) && digitsDoNotDecrease(digits)
}

fun hasAtLeastTwoIdenticalDigits(digits: List<Int>): Boolean {
    val digitCounts = mutableSetOf<Int>()
    for (digit in digits) {
        val added = digitCounts.add(digit)
        if (!added) {
            // Digit already present so we have at least two identical digits
            return true
        }
    }

    return false
}

fun digitsDoNotDecrease(digits: List<Int>): Boolean {
    return !digits.windowed(2, 1).any { pair ->  pair.first() > pair.second() }
}

fun digitize(number: Int) = number.toString().toList().map { it.toInt() }

fun <E> List<E>.second(): E {
    return this[1]
}
