# Tested on macos with Ruby 2.6.3p62

# root relative path for execution with repl.it
raw_input = File.read('./2020/day1/input').split

input = raw_input.map { |s| s.to_i }

numbers2020 = []
last_index = input.length - 1
(0..(last_index - 1)).each do |i|
  ((i + 1)..last_index).each do |j|
    numbers2020 = [input[i], input[j]] if input[i] + input[j] == 2020
  end
end

if numbers2020.empty?
  puts 'No solution found.'
else
  puts numbers2020[0] * numbers2020[1]
end
