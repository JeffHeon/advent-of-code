# root relative path for execution with repl.it
lines = File.readlines('./2020/day4/input').map(&:chomp)

chunks = lines.chunk { |line| !line.empty? }

password_chunks_keypair = chunks.select { |chunk| chunk.first }

passports_with_fields = password_chunks_keypair.map do |chunk|
  chunk[1]
    .map { |chunk_line| chunk_line.split }
    .flatten
end

Required_fields =
  ['byr', # (Birth Year)
   'iyr', # (Issue Year)
   'eyr', # (Expiration Year)
   'hgt', # (Height)
   'hcl', # (Hair Color)
   'ecl', # (Eye Color)
   'pid'].freeze # (Passport ID)
# "cid" #(Country ID) optional for now

def valid?(passport)
  Required_fields.all? do |field_id|
    passport.any? { |field| field.start_with? field_id }
  end
end

puts passports_with_fields.count { |passport| valid? passport }
