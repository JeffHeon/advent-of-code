# Tested on
# ruby 2.5.5p157 (2019-03-15 revision 67260) [x86_64-linux]

# All together now

# Prelude
Y = 0
X = 1

def count_trees(map, slope)
  map_width = map.first.length
  map_height = map.length
  current_position_yx = slope
  tree_count = 0

  while current_position_yx[Y] < map_height
    (y, x) = current_position_yx
    tree_count += 1 if map[y][x % map_width] == '#'
    y += slope[Y]
    x += slope[X]
    current_position_yx = [y, x]
  end

  tree_count
end

# root relative path for execution with repl.it
map = File.readlines('./2020/day3/input').map(&:chomp)

slopes = [[1, 1], [1, 3], [1, 5], [1, 7], [2, 1]]

all_tree_counts = slopes.map { |slope| count_trees(map, slope) }
puts all_tree_counts.reduce(&:*)
