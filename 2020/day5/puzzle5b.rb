def seatID(binarySpacePartitioning)
  row(binarySpacePartitioning) * 8 + column(binarySpacePartitioning)
end

def row(binarySpacePartitioning)
  binarySpacePartitioning[0, 7].gsub('B', '1').gsub('F', '0').to_i(2)
end

def column(binarySpacePartitioning)
  binarySpacePartitioning[7, 3].gsub('R', '1').gsub('L', '0').to_i(2)
end

def maxNumber(elements)
  max = elements.first
  elements[1..-1].each do |element|
    max = element > max ? element : max
  end
  max
end

# root relative path for execution with repl.it
raw_input = File.read('./2020/day5/input').split

seatIDs = raw_input.map { |s| seatID(s) }

# Find a seat that does not exist having seat with id + 1 and id -1 existing

# If we order the list, the first pair of ids separated by exactly 2 will indicate the missing seat in the middle

sorted_IDs = seatIDs.sort

for i in 0..sorted_IDs.length-2 do
  current_id = sorted_IDs[i]
  next_id = sorted_IDs[i+1] 
  if current_id + 2 == next_id
    puts current_id+1
    break
  end
end