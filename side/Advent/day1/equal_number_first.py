
with open("Advent\day1\input.txt") as temp_file:
    operations = [line.strip('\n') for line in temp_file]

total = 0

solution_lost = True
totals_list = set()

while (solution_lost == True):
    for i in operations:
        if i[0].count('+') == 1:
            total += int(i[1:])
            
        elif i[0].count('-') == 1:
            total -= int(i[1:])

        if total in totals_list:
            print("Final total = " + str(total))
            solution_lost = False
        else:
            totals_list.add(total)
print("back to the top of list. current length: " + str(len(totals_list)))

#Could be better