# Tested on macos with Ruby 2.6.3p62

raw_input = File.read("input").split

input=raw_input.map { |s| s.to_i }

numbers2020 = []
last_index = input.length - 1
for i in 0..(last_index-1) do
    for j in (i+1)..last_index do
        if input[i] + input[j] == 2020
            numbers2020 = [input[i], input[j]]
        end    
    end    
end

if numbers2020.empty?
    puts "No solution found."
else
    puts numbers2020[0] * numbers2020[1]    
end
