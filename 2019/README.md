## 2019 Kotlin

Some solutions to some days of [Advent of Code 2019](https://adventofcode.com/2019)

Using Kotlin _scripts_, although I developed them using an IDE.

Hats off to [darvs](https://github.com/darvs), who game me some tricks and tips for command line usage.

### Executing on MacOS

Install Kotlin with brew:

`brew install kotlin`

Given a script name `puzzle1.kts`, execute so:

`kotlinc -script puzzle1.kts`

Starting day 4 star 2, I am using a regular Kotlin file because I have problem debugging scripts.

You can run inside an IDE, or go through this cumbersome two-steps process on a command line.

```
kotlinc puzzle.kt -include-runtime -d uber.jar
java -jar uber.jar
```

Or *Kottle it!*, using this simple [Bash Script](kottle.sh).

**Note: I was using `print` at first, but the line wasn't written. I had to changed to `println`**

### Environment
Tested on macOS 10.15.1 with Kotlin version 1.3.61 (JRE 1.8.0_25-b17)
