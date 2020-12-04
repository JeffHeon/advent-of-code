# Tested on macos with Crystal 0.35.1 (2020-06-19)

raw_input = File.read("input").split

input=raw_input.map { |s| s.to_i }

numbers2020 = [] of Int32
last_index = input.size

(0..last_index-1).each do |i|
    (i+1..last_index-1).each do |j|
        if input[i] + input[j] == 2020
            numbers2020 = [input[i], input[j]]
        end    
    end    
end

if numbers2020.empty?
    puts "No solution found."
else
    puts "Number #{numbers2020[0]} and #{numbers2020[1]} sums to 2020."
    puts "Multiplied together: #{numbers2020[0] * numbers2020[1]}."  
end
