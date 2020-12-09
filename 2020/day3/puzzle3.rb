# Tested on 
# ruby 2.5.5p157 (2019-03-15 revision 67260) [x86_64-linux]

# Counting all the trees you would encounter for the slope right 3, down 1
# Do not count starting position (0, 0)

# The map is repeated "infinitely" on the right (technically no more than height / 3 times supposing a width of 4)

# Will use modulo width on the x coordinate to simulate repeated patterns

# root relative path for execution with repl.it
map_yx = File.readlines('./2020/day3/input').map(&:chomp)

map_width = map_yx.first.length
map_height = map_yx.length
current_position_yx = [1, 3]

tree_count = 0

Y = 0
X = 1

while current_position_yx[Y] < map_height do
  (y, x) = current_position_yx
  tree_count += 1 if map_yx[y][x % map_width] == '#'
  y += 1
  x += 3
  current_position_yx = [y, x]
end

puts tree_count
