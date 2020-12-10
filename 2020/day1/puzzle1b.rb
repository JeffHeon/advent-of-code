raw_input = File.read('./2020/day1/input').split

input = raw_input.map { |s| s.to_i }

numbers2020 = []
last_index = input.length - 1
(0..(last_index - 2)).each do |i|
  ((i + 1)..last_index - 1).each do |j|
    ((j + 1)..last_index - 2).each do |k|
      numbers2020 = [input[i], input[j], input[k]] if input[i] + input[j] + input[k] == 2020
    end
  end
end

if numbers2020.empty?
  puts 'No solution found.'
else
  puts numbers2020[0] * numbers2020[1] * numbers2020[2]
end
