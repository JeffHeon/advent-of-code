# BFFFBBFRRR: row 70, column 7, seat ID 567.
# FFFBBBFRRR: row 14, column 7, seat ID 119.
# BBFFBBFRLL: row 102, column 4, seat ID 820.

# BFFFBBF RRR
# BFFFBBF -> 1000110
# RRR -> 111
# "1000110".to_i(2) * 8 + "1000110".to_i(2)
# 70 * 8 + 7

# Prelude

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

puts maxNumber(seatIDs)
