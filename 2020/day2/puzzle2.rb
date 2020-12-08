# 1-3 a: abcde
# password must contain 'a' at least 1 time and at most 3 times

# Prelude

def valid?(password_with_scheme)
  tokens = password_with_scheme.match /(?<at_least>\d+)-(?<at_most>\d+) (?<letter>\w): (?<password>\w+)/
  count = tokens[:password].count tokens[:letter]
  at_least = tokens[:at_least].to_i
  at_most = tokens[:at_most].to_i
  return count >= at_least && count <= at_most
end

# root relative path for execution with repl.it
passwords_with_scheme = File.readlines('./2020/day2/input').map(&:chomp)

puts passwords_with_scheme.count { |password_with_scheme| valid?password_with_scheme }
