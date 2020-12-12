# root relative path for execution with repl.it
lines = File.readlines('./2020/day4/input').map(&:chomp)

chunks = lines.chunk { |line| !line.empty? }

password_chunks = chunks.select { |chunk| chunk.first }

puts password_chunks.first
