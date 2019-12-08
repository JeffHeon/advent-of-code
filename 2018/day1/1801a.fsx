open System.IO

let calculateTotal filename =
    filename
    |> File.ReadAllLines
    |> Array.map (fun change -> int change)
    |> Array.sum

let total = calculateTotal "input"

printfn "Total is %A" total
