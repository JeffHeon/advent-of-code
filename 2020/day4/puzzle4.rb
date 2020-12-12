# root relative path for execution with repl.it
lines = File.readlines('./2020/day4/input').map(&:chomp)

chunks = lines.chunk { |line| !line.empty? }

password_chunks_keypair = chunks.select { |chunk| chunk.first }

passwords_with_fields = password_chunks_keypair.map do |chunk|
  chunk[1]
    .map { |chunk_line| chunk_line.split }
    .flatten
end

print passwords_with_fields
