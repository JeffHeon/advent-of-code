package jeff

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

fun String.rest(): String = drop(1)
