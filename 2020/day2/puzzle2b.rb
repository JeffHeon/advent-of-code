# 1-3 a: abcde
# password must contain 'a' either at position 1 or 3 but not both.
# Note: 1-based index (as it should be!)

# Prelude

def valid?(password_with_scheme)
  tokens = password_with_scheme.match(/(?<first_position>\d+)-(?<second_position>\d+) (?<letter>\w): (?<password>\w+)/)
  password = tokens[:password]
  letter = tokens[:letter]
  first_letter = password[tokens[:first_position].to_i - 1]
  second_letter = password[tokens[:second_position].to_i - 1]
  # ^ is exclusive or
  return (first_letter == letter) ^ (second_letter == letter)
end

# root relative path for execution with repl.it
passwords_with_scheme = File.readlines('./2020/day2/input').map(&:chomp)

puts passwords_with_scheme.count { |password_with_scheme| valid? password_with_scheme }
