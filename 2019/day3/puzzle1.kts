package day3

import java.io.File
import kotlin.math.absoluteValue

// Some list utility functions demonstrating I still ♥️ Clojure
fun <T> List<T>.second(): T {
    return rest().first()
}

fun <T> List<T>.rest(): List<T> {
    if (size < 1)
        throw NoSuchElementException("List is empty.")
    // Note: subList is using the original list underneath instead of making a copy,
    // so this is a cheap operation
    return this.subList(1, size)
}

data class Point(val x: Int, val y: Int)

operator fun Point.plus(delta: Point) = Point(x + delta.x, y + delta.y)

// This is pretty weird to me. I'm extending the class with a new calculated property?
// It could probably be made lazy also.
val Point.manhattanDistance: Int get() = x.absoluteValue + y.absoluteValue
// The 'simple' function extension is easier to understand, but have the extra parenthesis on definition and call
// fun Point.manhattanDistance(): Int  = x.absoluteValue + y.absoluteValue

data class Move(val direction: Char, val length: Int)

// Note
// I originally wanted to make Segment a sealed classes with Vertical & Horizontal subclasses.
// However, there are some issues using sealed classes in a Kotlin script.
// https://stackoverflow.com/a/52832035
// https://youtrack.jetbrains.com/issue/KT-20180
data class Segment(val start: Point, val end: Point)

// We are assuming a cartesian coordinate system.
// (x increasing going right and y increasing going up.)
// We posit the central central port is located at 0,0.
fun wireSegments(wirePath: List<String>): List<Segment> {
    val moves = wirePath.map { token -> Move(token.first(), token.drop(1).toInt()) }
    var segments = mutableListOf<Segment>()
    var currentPosition = Point(0, 0)
    moves.forEach { move ->
        val delta = when (move.direction) {
            'U' -> Point(0, move.length)
            'D' -> Point(0, -move.length)
            'L' -> Point(-move.length, 0)
            'R' -> Point(move.length, 0)
            else -> throw IllegalArgumentException("Illegal wire move $move")
        }
        val newPosition = currentPosition + delta
        segments.add(Segment(currentPosition, newPosition))
        currentPosition = newPosition
    }

    return segments
}

fun closestIntersection(wirePath1: List<String>, wirePath2: List<String>): Point {
    val wireSegments1 = wireSegments(wirePath1)
    val wireSegments2 = wireSegments(wirePath2)

    // Find all intersections between the two list of segments
    // Select the smallest one by Manhattan distance
    val intersections: List<Point> = wireIntersections(wireSegments1, wireSegments2)

    // Exclude central port (0, 0)
    val filtered = intersections.filter { it != Point(0, 0) }

    if (filtered.isEmpty()) {
        throw NoSuchElementException("No wire intersection found")
    } else {
        return filtered.minBy { it.manhattanDistance }!!
    }
}

// We're only going to consider intersections of vertical with horizontal segments
// and ignore vertical segments joining together.
fun wireIntersections(wireSegments1: List<Segment>, wireSegments2: List<Segment>): List<Point> {
    val (verticals1, horizontals1) = splitVerticalsHorizontals(wireSegments1)
    val (verticals2, horizontals2) = splitVerticalsHorizontals(wireSegments2)
    val intersections1: List<Point> = intersections(verticals1, horizontals1)
    val intersections2: List<Point> = intersections(verticals2, horizontals2)

    return intersections1 + intersections2
}

fun splitVerticalsHorizontals(wireSegments1: List<Puzzle1.Segment>) =
    wireSegments1.partition { it.start.x == it.end.x }

fun intersections(verticals: List<Segment>, horizontals: List<Segment>): List<Point> {
    return verticals.flatMap { v -> horizontals.mapNotNull { h -> intersection(v, h) } }
}

fun intersection(vertical: Segment, horizontal: Segment): Point? {
    val rangeX = range(horizontal.start.x, horizontal.end.x)
    if (vertical.start.x in rangeX) {
        val rangeY = range(horizontal.start.y, horizontal.end.y)
        if (horizontal.start.y in rangeY) {
            return Point(vertical.start.x, horizontal.start.y)
        }
    }

    return null
}

// Orient range because a decreasing range does not work unless written with downTo.
// E.g. 1..10: ok. 10..1: empty range! Must use 10 downTo 1 (or orient to 1..10)
fun range(a: Int, b: Int) = if (a < b) a..b else b..a

// The actual program
//val input = File("input").readLines()
val input = listOf("R8,U5,L5,D3", "U7,R6,D4,L4")
val wirePath1 = input.first().split(",")
val wirePath2 = input.second().split(",")

val intersection = closestIntersection(wirePath1, wirePath2)
val distance = intersection.manhattanDistance
println("intersection $intersection, distance $distance")
println("end of struggle")
