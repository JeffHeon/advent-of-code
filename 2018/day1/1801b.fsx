open System.IO

let inputFrequencyChanges filename =
    filename
    |> File.ReadAllLines
    |> Array.map (fun change -> int change)

let firstRepeatedFrequency frequencyChanges =
    let mutable foundRepeatedFrequency = false
    let mutable currentIndex = 0
    let mutable currentFrequency = 0
    let mutable seenFrequencies = Set.empty<int>
    let changesLength = Array.length frequencyChanges
    while (not foundRepeatedFrequency) do
        let change = frequencyChanges.[currentIndex]
        let newFrequency = currentFrequency + change
        currentFrequency <- newFrequency
        currentIndex <- (currentIndex + 1) % changesLength
        if Set.contains currentFrequency seenFrequencies then
            printfn "First Repeated Frequency is %A" currentFrequency
            foundRepeatedFrequency <- true
            ignore
        else
            seenFrequencies <- Set.add currentFrequency seenFrequencies
            ignore

"input" |> inputFrequencyChanges |> firstRepeatedFrequency |> ignore
