

with open("Advent\day1\input.txt") as temp_file:
    operations = [line.strip('\n') for line in temp_file]

total = 0

print(operations[0][0])

for i in operations:
    if i[0].count('+') == 1:
        total += int(i[1:])
    elif i[0].count('-') == 1:
        total -= int(i[1:])

print(total)